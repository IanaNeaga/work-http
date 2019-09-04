package com.sda.httpExample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class RequestExample {

    public static void main(String[] args) throws IOException {

        URL url=new URL("https://jsonplaceholder.typicode.com/posts/5");

        HttpURLConnection connection=(HttpURLConnection) url.openConnection();

        connection.setRequestMethod("GET");
        int responseCode=connection.getResponseCode();
        System.out.println("Response code: "+responseCode);
        if(responseCode==HttpURLConnection.HTTP_OK){

            BufferedReader reader=new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String line="";
            while((line=reader.readLine())!=null){
                System.out.println(line);
            }
        }
    }
}
