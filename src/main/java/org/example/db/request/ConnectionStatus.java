package org.example.db.request;

import org.example.client.AbstractClientGui;
import org.example.config.HostConfig;
import org.example.db.request.AbstractRequest.AbstractConnectionStatus;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ConnectionStatus extends AbstractConnectionStatus {

    public ConnectionStatus(AbstractClientGui clientGui) {
        super(clientGui);
    }

    @Override
    public void status() {
        try (Socket socket = new Socket(HostConfig.getHost(), HostConfig.getPort());
             PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            writer.println("db_status");
            String[] textPart = reader.readLine().split(":");
            if (textPart[1].equalsIgnoreCase("Active")) {
                JOptionPane.showMessageDialog(CLIENT_GUI, "<html>Server jest: <b>Aktywny</b> <br> Baza danych jest: <b>Aktywna</b> </html>");
            } else {
                JOptionPane.showMessageDialog(CLIENT_GUI, "<html>Server jest: <b>Aktywny</b> <br> Baza danych jest: <b>Nieaktywna</b> </html>");
            }
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(CLIENT_GUI, "<html>Server jest: <b>Nieaktywny</b> <br> Baza danych jest: <b>Nieaktywna</b> </html>");
        }
    }
}
