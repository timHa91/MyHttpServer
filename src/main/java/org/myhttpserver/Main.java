package org.myhttpserver;


import org.myhttpserver.httpserver.HttpServer;
import org.myhttpserver.httpserver.config.ConfigurationManager;


public class Main {
    public static void main(String[] args) {
        ConfigurationManager.getInstance().loadConfig("src/main/resources/configuration.json");
        HttpServer httpServer = new HttpServer();
        httpServer.run();
    }
}