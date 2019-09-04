package com.sda.httpExample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class URLConnectionExample {

    public static void main(String[] args) throws IOException {

        URL url=new URL("https://www.google.com/?gws_rd=ssl");

        System.out.println("protocol: "+url.getProtocol());
        System.out.println("port: "+url.getPort());
        System.out.println("host: "+url.getHost());
        System.out.println("file name: "+url.getFile());

        URLConnection connection=url.openConnection();
        BufferedReader reader=new BufferedReader(new InputStreamReader((InputStream) connection.getContent()));

        String line;
        while((line=reader.readLine())!=null){
            System.out.println(line);
        }
    }
}
