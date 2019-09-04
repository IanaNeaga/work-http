package com.sda.httpExample;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class PostExample {

    public static void main(String[] args) throws IOException {

        URL url=new URL("https://jsonplaceholder.typicode.com/posts");

        HttpURLConnection connection=(HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        OutputStream outputStream = connection.getOutputStream();

        outputStream.write("content".getBytes());
        outputStream.flush();
        outputStream.close();

        System.out.println("Reponse code: "+connection.getResponseCode());
        System.out.println("Reponse message: "+connection.getResponseMessage());
    }
}
