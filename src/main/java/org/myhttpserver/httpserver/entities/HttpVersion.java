package org.myhttpserver.httpserver.entities;

public enum HttpVersion {
    HTTP_1_1("HTTP/1.1"),
    HTTP_1_0("HTTP/1.0");

    private final String version;

    HttpVersion(String version) {
        this.version = version;
    }

    public String getVersion() {
        return version;
    }
}
