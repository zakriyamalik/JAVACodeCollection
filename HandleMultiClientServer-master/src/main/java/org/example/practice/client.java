package org.example.practice;

import java.io.*;
import java.net.*;

public class client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 12345)) {
            System.out.println("Connected to the server!");

            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));

            String userInput;
            while (true) {
                System.out.print("Enter message (type 'bye' to quit): ");
                userInput = consoleInput.readLine();
                output.println(userInput);

                if (userInput.equalsIgnoreCase("bye")) {
                    System.out.println("Connection closed by client.");
                    break;
                }

                String serverResponse = input.readLine();
                System.out.println("Server says: " + serverResponse);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
