package org.example.config;

public class DBConfig {
    private static final String URL;
    private static final String USER;
    private static final String PASSWORD;
    private static final String Name;

    public static String getURL() {
        return URL;
    }

    public static String getUser() {
        return USER;
    }

    public static String getPassword() {
        return PASSWORD;
    }

    public static String getName() {
        return Name;
    }

    public static String getFullURL() {
        return URL + Name;
    }

    static {
        URL = "jdbc:mysql://localhost:3306/";
        USER = "root";
        PASSWORD = "";
        Name = "shop";
    }
}
