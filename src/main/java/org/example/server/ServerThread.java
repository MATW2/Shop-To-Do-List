package org.example.server;

import org.example.config.ServerConfig;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerThread extends ServerConfig{

    public ServerThread(Socket socket) {
        super(socket);
    }

    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            String text;
            while ((text = reader.readLine()) != null) {
                    if (text.startsWith("read")) READ_PRODUCT.read(text);
                    if (text.startsWith("add")) ADD_PRODUCT.add(text);
                    if (text.startsWith("edit")) EDIT_PRODUCT.edit(text);
                    if (text.startsWith("delete")) DELETE_PRODUCT.delete(text);
                    if (text.startsWith("db_status")) CONNECTION_STATUS.status();
                    if (text.startsWith("raport")) RAPORT.raport(text);
            }
        } catch (IOException ignored) {}
    }
}