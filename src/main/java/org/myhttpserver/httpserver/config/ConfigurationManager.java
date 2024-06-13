package org.myhttpserver.httpserver.config;

import com.fasterxml.jackson.databind.JsonNode;
import org.myhttpserver.httpserver.error.HttpConfigurationException;
import org.myhttpserver.httpserver.utils.Json;
import org.myhttpserver.httpserver.utils.Validation;

import java.io.IOException;

public class ConfigurationManager {

    private static ConfigurationManager instance;

    private Configuration configuration;

    private ConfigurationManager() {

    }

    public static ConfigurationManager getInstance() {
        if (instance == null) {
            instance = new ConfigurationManager();
        }
        return instance;
    }

    public void loadConfig(String filepath) {
        try {
            String src = Json.readJsonFileToString(filepath);
            JsonNode node = Json.parse(src);

            Validation.validateConfigNode(node);

            configuration = Json.fromJson(node, Configuration.class);

            printConfiguration();
        } catch (IOException e) {
            throw new HttpConfigurationException("Error loading the Configuration File", e);
        }
    }

    public Configuration getConfiguration() {
        if (configuration == null) {
            throw new HttpConfigurationException("No current Configuration Set.");
        }
        return this.configuration;
    }

    public void printConfiguration() {
        System.out.println("Konfiguration geladen: ");
        System.out.println("Host: " + configuration.getHost());
        System.out.println("Webroot: " + configuration.getWebroot());
        System.out.println("Port: " + configuration.getPort());
        System.out.println("Request Timeout: " + configuration.getRequestTimeout());
        System.out.println("Read Buffer Size: " + configuration.getReadBufferSize());
        System.out.println("Max Request Size: " + configuration.getMaxRequestSize());
        System.out.println("Concurrency: " + configuration.getConcurrency());
    }
}
