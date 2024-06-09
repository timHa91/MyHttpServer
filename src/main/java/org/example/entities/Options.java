package org.example.entities;

import java.time.Duration;

public class Options {
    private String host;
    private int port;
    private Duration requestTimeout;
    private int readBufferSize;
    private int maxRequestSize;
    private int concurrency;

    private Options(String host, int port, Duration requestTimeout, int readBufferSize, int maxRequestSize, int concurrency) {
    }

    public static class Builder {

        private String host;
        private int port;
        private Duration requestTimeout;
        private int readBufferSize;
        private int maxRequestSize;
        private int concurrency;

        private Builder() {
            // Setzen von Standardwerten
            this.host = "localhost";
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

        public Options build() {
            return new Options(
                this.host,
                    this.port,
                    this.requestTimeout,
                    this.readBufferSize,
                    this.maxRequestSize,
                    this.concurrency
            );
        }
    }
}
