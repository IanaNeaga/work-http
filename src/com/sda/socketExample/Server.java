package com.sda.socketExample;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    static final int port =8082;

    public static void main(String args[]){
        startServer();
    }

    public static void startServer(){

        System.out.println("Creating server on port :"+port);
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            while(true) {
                Socket socket = serverSocket.accept();
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                OutputStream outputStream = socket.getOutputStream();

                PrintWriter printWriter = new PrintWriter(outputStream,true);



                String message = reader.readLine();
                System.out.println("received message: "+message);

                printWriter.println("Hello, " + message);
                printWriter.close();
                socket.close();
            }

        }catch(IOException e){
            System.out.println(e);
        }
    }
}
