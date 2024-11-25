package org.example;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client3 {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 12345);
            System.out.println("Connected to server.");

            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            Scanner scanner = new Scanner(System.in);

            // Read username request and send username
            System.out.println(input.readLine());
            String username = scanner.nextLine();
            output.println(username);

            // Start a thread to listen for incoming messages
            new Thread(() -> {
                try {
                    String serverMsg;
                    while ((serverMsg = input.readLine()) != null) {
                        System.out.println(serverMsg);
                    }
                } catch (IOException e) {
                    System.out.println("Error reading from server: " + e.getMessage());
                }
            }).start();

            // Send messages to the server
            String clientMsg;
            while (true) {
                clientMsg = scanner.nextLine();
                output.println(clientMsg);
                if ("STOP".equalsIgnoreCase(clientMsg)) {
                    break;
                }
            }

            socket.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
