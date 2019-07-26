
package com.webservice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;



public class GetWebservice {
    
    public  String doPost(String urlHttp){    
        String responseHttp="error";
        String output="";
          try {

		URL url = new URL(urlHttp);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-Type", "text/xml");
                
		if (conn.getResponseCode() != 200) {
                    System.out.println("Error call Webservice Url: "+url);
                    return output;                        
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(
			(conn.getInputStream())));

		
		System.out.println("Output from Server .... \n");
		while ((output = br.readLine()) != null) {
			System.out.println(output);
                        responseHttp = output;
		}

		conn.disconnect();

	  } catch (MalformedURLException e) {

		e.printStackTrace();

	  } catch (IOException e) {

		e.printStackTrace();

	  }
            return responseHttp;
	}
  
    
    }

