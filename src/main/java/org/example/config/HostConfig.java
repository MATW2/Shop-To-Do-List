package org.example.config;

public class HostConfig {
    private final static String HOST;
    private final static int PORT;

    public static String getHost() {
        return HOST;
    }

    public static int getPort() {
        return PORT;
    }

    static {
        HOST = "localhost";
        PORT = 12345;
    }
}
