package org.myhttpserver.httpserver.entities;

import java.util.HashMap;
import java.util.Map;

public class Header {
    Map<String, String> headers = new HashMap<>();

    public void setHeaders(String name, String value) throws IllegalArgumentException {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Header cannot be empty");
        }
        headers.put(name, value != null ? value : "");
    }

    public String getHeader(String name) throws IllegalArgumentException {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Header cannot be empty");
        }
        return headers.get(name);
    }

    public Map<String, String> getHeaders() {
        return headers;
    }
}
