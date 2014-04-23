package com.laazer.common;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class UrlManager {
    public static String excutePost(String targetURL, String urlParameters)
    {
      URL url;
      HttpURLConnection connection = null;  
      try {
        //Create connection
        url = new URL(targetURL);
        connection = (HttpURLConnection)url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", 
             "application/x-www-form-urlencoded");
              
        connection.setRequestProperty("Content-Length", "" + 
                 Integer.toString(urlParameters.getBytes().length));
        connection.setRequestProperty("Content-Language", "en-US");  
              
        connection.setUseCaches (false);
        connection.setDoInput(true);
        connection.setDoOutput(true);

        //Send request
        DataOutputStream wr = new DataOutputStream (
                    connection.getOutputStream ());
        wr.writeBytes (urlParameters);
        wr.flush ();
        wr.close ();

        //Get Response    
        InputStream is = connection.getInputStream();
        BufferedReader rd = new BufferedReader(new InputStreamReader(is));
        String line;
        StringBuffer response = new StringBuffer(); 
        while((line = rd.readLine()) != null) {
          response.append(line);
          response.append('\r');
        }
        rd.close();
        return response.toString();

      } catch (Exception e) {

        e.printStackTrace();
        return null;

      } finally {

        if(connection != null) {
          connection.disconnect(); 
        }
      }
    }
    
    public void main(String[] args) {
       String target = "https://prod.api.pvp.net/api/lol/na/v1.4/summoner/by-name/InvParadox?api_key=f123e66a-3511-4219-bd29-71d8e315e603";
       String result = UrlManager.excutePost(target, "");
       System.out.println(result);
    }
}
