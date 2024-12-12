package org.example.practice;

import java.io.*;
import java.net.*;

public class server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            System.out.println("Server is listening on port 12345...");
            Socket socket = serverSocket.accept();
            System.out.println("Client connected!");

            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader serverInput = new BufferedReader(new InputStreamReader(System.in)); // Server input

            String clientMessage;
            while ((clientMessage = input.readLine()) != null) {
                System.out.println("Client says: " + clientMessage);

                // Prompt the server user for a response
                System.out.print("Enter your response: ");
                String response = serverInput.readLine();
                output.println(response);

                if (clientMessage.equalsIgnoreCase("bye")) {
                    System.out.println("Client disconnected!");
                    break;
                }
            }

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
