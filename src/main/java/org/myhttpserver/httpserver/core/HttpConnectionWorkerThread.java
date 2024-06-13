package org.myhttpserver.httpserver.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class HttpConnectionWorkerThread extends Thread{
    private final Logger LOGGER = LoggerFactory.getLogger(HttpConnectionWorkerThread.class);
    private final Socket CLIENT_SOCKET;

    public HttpConnectionWorkerThread(Socket CLIENT_SOCKET) {
        this.CLIENT_SOCKET = CLIENT_SOCKET;
    }

    @Override
    public void run() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(CLIENT_SOCKET.getInputStream()));
             PrintWriter out = new PrintWriter(CLIENT_SOCKET.getOutputStream(), true)) {

            // 1. HTTP-Anfrage lesen
            String requestLine = in.readLine();
            LOGGER.info("Request received: {}", requestLine);

            // 2. HTTP-Antwort vorbereiten
            String responseBody = "<html><body><h1>Hello, HTTP Server!</h1></body></html>";
            out.println("HTTP/1.1 200 OK");
            out.println("Content-Type: text/html");
            out.println("Content-Length: " + responseBody.length());
            out.println();
            out.println(responseBody);
        } catch (IOException e) {
            LOGGER.error("Error while handling request: {}", e.getMessage());
        } finally {
            try {
                CLIENT_SOCKET.close();
            } catch (IOException e) {
                LOGGER.error("Error closing client socket: {}", e.getMessage());
            }
        }
    }
}
