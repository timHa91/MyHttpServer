package org.myhttpserver.httpserver.entities;

public class Request {
    private final HttpMethod method;
    private final String uri;
    private final Header header;
    private String body;

    public Request(HttpMethod method, String uri, Header header, String body) {
        this.method = method;
        this.uri = uri;
        this.header = header;
        setBody(body);
    }

    public void setBody(String body) {
        if(method.equals(HttpMethod.POST) || method.equals(HttpMethod.PUT)) {
            this.body = body;
        } else {
            this.body = null;
        }
    }

    @Override
    public String toString() {
        return "Request{" +
                "method=" + method +
                ", uri='" + uri + '\'' +
                ", header=" + header +
                ", body='" + body + '\'' +
                '}';
    }
}
