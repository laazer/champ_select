package com.laazer.common;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class UrlManager {
    public static String executeGet(String target) {
        String result = "";
        try {
           HttpsURLConnection con = (HttpsURLConnection)(new URL(target).openConnection());          
            BufferedReader br = 
                    new BufferedReader(
                            new InputStreamReader(con.getInputStream()));

            String input;

            while ((input = br.readLine()) != null){
                System.out.println(input);
                result = result + input + "\n";
            }
            br.close();

        } catch (IOException e) {
            e.printStackTrace();
            result = e.toString();
        }
        return result;

    }
}
