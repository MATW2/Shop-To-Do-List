package org.example.server;

import org.example.config.HostConfig;
import org.example.db.DB;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(HostConfig.getPort())) {
            DB.connection();
            while (true) new ServerThread(serverSocket.accept()).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}







