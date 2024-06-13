package org.myhttpserver.httpserver.config;

import java.time.Duration;

public class Configuration {
    private String host;
    private String webroot;
    private int port;
    private Duration requestTimeout;
    private int readBufferSize;
    private int maxRequestSize;
    private int concurrency;

    // No-args Konstruktor für Jackson
    public Configuration() {
    }

    public Configuration(String host, String webroot, int port, Duration requestTimeout, int readBufferSize, int maxRequestSize, int concurrency) {
    }

    public String getHost() {
        return host;
    }

    public String getWebroot() {
        return webroot;
    }

    public int getPort() {
        return port;
    }

    public Duration getRequestTimeout() {
        return requestTimeout;
    }

    public int getReadBufferSize() {
        return readBufferSize;
    }

    public int getMaxRequestSize() {
        return maxRequestSize;
    }

    public int getConcurrency() {
        return concurrency;
    }

    public static class Builder {

        private String host;
        private String webroot;
        private int port;
        private Duration requestTimeout;
        private int readBufferSize;
        private int maxRequestSize;
        private int concurrency;

        private Builder() {
            // Setzen von Standardwerten
            this.host = "localhost";
            this.webroot = "";
            this.port = 8080;
            this.requestTimeout = Duration.ofSeconds(60);
            this.readBufferSize = 1_024 * 64;
            this.maxRequestSize = 1_024 * 1_024;
            this.concurrency = Runtime.getRuntime().availableProcessors();
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder withHost(String host) {
            this.host = host;
            return this;
        }

        public Builder withWebroot(String webroot) {
            this.webroot = webroot;
            return this;
        }

        public Builder withPort(int port) {
            this.port = port;
            return this;
        }

        public Builder withRequestTimeout(Duration requestTimeout) {
            this.requestTimeout = requestTimeout;
            return this;
        }

        public Builder withMaxRequestSize(int maxRequestSize) {
            this.maxRequestSize = maxRequestSize;
            return this;
        }

        public Builder withConcurrency(int concurrency) {
            this.concurrency = concurrency;
            return this;
        }

        public Builder withReadBufferSize(int readBufferSize) {
            this.readBufferSize = readBufferSize;
            return this;
        }

        public Configuration build() {
            return new Configuration(
                    this.host,
                    this.webroot,
                    this.port,
                    this.requestTimeout,
                    this.readBufferSize,
                    this.maxRequestSize,
                    this.concurrency
            );
        }
    }
}
