package org.example;

import java.io.*;
import java.net.*;
import java.util.*;

public class MultiClientServer {
    private static Map<String, PrintWriter> clients = new HashMap<>();

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(12345);
        System.out.println("Server is running and waiting for clients...");

        while (true) {
            Socket clientSocket = server.accept();
            System.out.println("A new client connected!");
            new ClientHandler(clientSocket).start();
        }
    }

    static class ClientHandler extends Thread {
        private Socket socket;
        private String username;
        private BufferedReader input;
        private PrintWriter output;

        public ClientHandler(Socket socket) throws IOException {
            this.socket = socket;
            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            output = new PrintWriter(socket.getOutputStream(), true);
        }

        @Override
        public void run() {
            try {
                // Get a unique username
                output.println("Enter your username:");
                username = input.readLine();

                synchronized (clients) {
                    if (clients.containsKey(username)) {
                        output.println("Username already taken. Try again with a different username.");
                        socket.close();
                        return;
                    }
                    clients.put(username, output);
                }

                output.println("Welcome, " + username + "! You can start chatting. Type 'STOP' to exit.");
                broadcast(username + " has joined the chat.", null);

                String clientMsg;
                while ((clientMsg = input.readLine()) != null) {
                    if ("STOP".equalsIgnoreCase(clientMsg)) {
                        break;
                    }
                    broadcast(username + ": " + clientMsg, username);
                }
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            } finally {
                try {
                    synchronized (clients) {
                        clients.remove(username);
                    }
                    broadcast(username + " has left the chat.", null);
                    socket.close();
                } catch (IOException e) {
                    System.out.println("Error closing socket: " + e.getMessage());
                }
            }
        }

        private void broadcast(String message, String senderUsername) {
            synchronized (clients) {
                for (Map.Entry<String, PrintWriter> entry : clients.entrySet()) {
                    if (!entry.getKey().equals(senderUsername)) {
                        entry.getValue().println(message);
                    }
                }
            }
        }
    }
}
