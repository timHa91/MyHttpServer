package org.myhttpserver.httpserver.utils;

import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

public class Validation {

    public static void validateConfigNode(JsonNode node) throws IOException {
        if(!node.has("host")) {
            throw new IOException("Host field is missing");
        }

        if(!node.has("port")) {
            throw new IOException("Port field is missing");
        }

        int port = node.get("port").asInt();
        if (port < 1 || port > 65535) {
            throw new IOException("Port number must be between 1 and 65535");
        }
    }
}
