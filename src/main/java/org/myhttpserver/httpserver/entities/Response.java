package org.myhttpserver.httpserver.entities;

public class Response {
    private final HttpVersion version;
    private final HttpStatus status;
    private final Header header;
    private final String body;

    public Response(HttpVersion version, HttpStatus status, Header header, String body) {
        this.version = version;
        this.status = status;
        this.header = header;
        this.body = body;
    }

    @Override
    public String toString() {
        return "Response{" +
                "version=" + version +
                ", status=" + status +
                ", header=" + header +
                ", body='" + body + '\'' +
                '}';
    }
}
