package com.sda.socketExample;

import java.io.*;
import java.net.Socket;

public class Client {
    private Socket socket = null;

    public Client(String host, int port) {
        while (true) {
            try {
                socket = new Socket(host, port);
                //take input from terminal
                PrintWriter writer = new PrintWriter(socket.getOutputStream(),true);

                BufferedReader userInputBR = new BufferedReader(new InputStreamReader(System.in));
                String userInput = userInputBR.readLine();
                writer.println(userInput);
                System.out.println("Sent Message " + userInput);

                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                System.out.println("Received Message: " + reader.readLine());

                if ("exit".equalsIgnoreCase(userInput)) {
                    socket.close();
                    break;
                }
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }

    public static void main(String args[]){
        Client client = new Client("192.168.1.197",8082);
    }
}
