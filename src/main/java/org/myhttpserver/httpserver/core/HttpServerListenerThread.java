package org.myhttpserver.httpserver.core;

import org.myhttpserver.httpserver.config.Configuration;
import org.myhttpserver.httpserver.config.ConfigurationManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServerListenerThread extends Thread{

    private final Logger LOGGER = LoggerFactory.getLogger(HttpServerListenerThread.class);
    private final Configuration configuration;

    {
        configuration = ConfigurationManager.getInstance().getConfiguration();
    }

    @Override
    public void run() {
        LOGGER.info("Server starting...");
        int port = configuration.getPort();
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            LOGGER.info("HTTP Server is listening on port {}", port);
            while (serverSocket.isBound() && !serverSocket.isClosed()) {
                try {
                    Socket clientSocket = serverSocket.accept();
                    LOGGER.info("New connection: {}", clientSocket);

                    // Handle HTTP request in a separate thread
                   new HttpConnectionWorkerThread(clientSocket).start();
                } catch (IOException e) {
                    LOGGER.error("Error accepting connection: {}", e.getMessage());
                }
            }
        } catch (IOException e) {
            LOGGER.error("Error starting server: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
