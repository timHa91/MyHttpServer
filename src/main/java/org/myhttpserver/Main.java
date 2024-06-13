package org.myhttpserver;


import org.myhttpserver.httpserver.core.HttpServerListenerThread;
import org.myhttpserver.httpserver.config.ConfigurationManager;


public class Main {
    public static void main(String[] args) {
        ConfigurationManager.getInstance().loadConfig("src/main/resources/configuration.json");
        HttpServerListenerThread httpServer = new HttpServerListenerThread();
        httpServer.start();
    }
}