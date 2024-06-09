package org.example.entities;

public class Response {
    private HttpVersion version;
    private HttpStatus status;
    private Header header;
    private String body;

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
