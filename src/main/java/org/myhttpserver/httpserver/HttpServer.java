package org.myhttpserver.httpserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {

    public void run() {
        int port = 8080; // Portnummer angeben
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("HTTP Server is listening on port " + port);

            while (true) {
                try {
                    Socket clientSocket = serverSocket.accept();
                    System.out.println("New connection: " + clientSocket);

                    // Handle HTTP request in a separate thread
                    new Thread(() -> handleHTTPRequest(clientSocket)).start();
                } catch (IOException e) {
                    System.err.println("Error accepting connection: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Error starting server: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    private static void handleHTTPRequest(Socket clientSocket) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

            // 1. HTTP-Anfrage lesen
            String requestLine = in.readLine();
            System.out.println("Request received: " + requestLine);

            // 2. HTTP-Antwort vorbereiten
            String responseBody = "<html><body><h1>Hello, HTTP Server!</h1></body></html>";
            out.println("HTTP/1.1 200 OK");
            out.println("Content-Type: text/html");
            out.println("Content-Length: " + responseBody.length());
            out.println();
            out.println(responseBody);
        } catch (IOException e) {
            System.err.println("Error while handling request: " + e.getMessage());
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                System.err.println("Error closing client socket: " + e.getMessage());
            }
        }
    }
}
