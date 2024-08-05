package org.example.db.request.AbstractRequest;

import org.example.client.AbstractClientGui;
import org.example.config.HostConfig;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public abstract class AbstractConnectionStatus {
    protected final AbstractClientGui CLIENT_GUI;

    public AbstractClientGui getCLIENT_GUI() {
        return CLIENT_GUI;
    }

    public AbstractConnectionStatus(AbstractClientGui clientGui) {
        this.CLIENT_GUI = clientGui;
    }

    public static boolean isConnection() {
        try (Socket socket = new Socket(HostConfig.getHost(), HostConfig.getPort());
             PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            writer.println("db_status");
            String[] textPart = reader.readLine().split(":");
            return textPart[1].equalsIgnoreCase("Active");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public abstract void status();
}
