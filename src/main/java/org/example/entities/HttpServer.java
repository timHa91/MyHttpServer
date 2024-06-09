package org.example.entities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {

    public void run() {
        try(ServerSocket serverSocket = new ServerSocket()) {
            System.out.println("HTTP Server is listening on port ");

            while (true) {
                try(Socket clientSocket = serverSocket.accept()) {
                    System.out.println("New connection: " + clientSocket);

                    // Handle HTTP request in a separate thread or method
                    handleHTTPRequest(clientSocket);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void handleHTTPRequest(Socket socket) {
        try(BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            PrintWriter printWriter = n
        } catch (IOException e) {
            System.err.println("Error while handling request: " + e.getMessage());
        }
    }
}
