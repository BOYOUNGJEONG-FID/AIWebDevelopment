package my.jes.web.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class TMapRequestor {
	public static String request(String urlString) {
		HttpURLConnection con=null;
		BufferedReader br=null;
		try {	
           
			URL url=new URL(urlString);
			con=(HttpURLConnection) url.openConnection();
			con.setRequestMethod("POST");	
			//con.setRequestProperty("appKey", "put your client-id");
			con.setRequestProperty("appKey", "");
		
			br=new BufferedReader(new InputStreamReader(con.getInputStream()));
			String oneLine,sum="";
			while((oneLine=br.readLine()) != null) {
				sum +=oneLine; 
			}
			//System.out.println("sum" +sum);
			return sum;
		} catch (Exception e) {			
			//e.printStackTrace();
			//System.out.println("catch error" );
			return null;
		} finally {
			if(br !=null )
				try {
					br.close();
				} catch (IOException e) {					
				}
		}

	}
	
	public static String coordConvert(double lon, double lat) {
		HttpURLConnection con=null;
		BufferedReader br=null;
		try {	
            String urlString = "https://apis.openapi.sk.com/tmap/geo/coordconvert?version=1&format=json&callback=result";
            urlString =urlString + "&lon="+ Double.toString(lon) + "&lat=" + Double.toString(lat) +"&fromCoord=WGS84GEO"+ "&toCoord=KATECH"; 
            System.out.println(urlString);

			URL url=new URL(urlString);
			con=(HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");	
			//con.setRequestProperty("appKey", "put your client-id");
			con.setRequestProperty("appKey", "");
		
			br=new BufferedReader(new InputStreamReader(con.getInputStream()));
			String oneLine,sum="";
			while((oneLine=br.readLine()) != null) {
				sum +=oneLine; 
			}
			//System.out.println("sum" +sum);
			return sum;
		} catch (Exception e) {			
			//e.printStackTrace();
			//System.out.println("catch error" );
			return null;
		} finally {
			if(br !=null )
				try {
					br.close();
				} catch (IOException e) {					
				}
		}
		
	}

}
