package org.example.db.request;

import org.example.client.AbstractClientGui;
import org.example.config.HostConfig;
import org.example.db.request.AbstractRequest.AbstractRaport;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Raport extends AbstractRaport {

    public Raport(AbstractClientGui clientGui) {
        super(clientGui);
    }

    @Override
    public void report() {
        String message = JOptionPane.showInputDialog(CLIENT_GUI, "Opisz problem");
        if (message != null && !message.isEmpty()) {
            try (Socket socket = new Socket(HostConfig.getHost(), HostConfig.getPort());
                 PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
                 BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                writer.println("raport:" + message);
                JOptionPane.showMessageDialog(CLIENT_GUI, reader.readLine());
            } catch (UnknownHostException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(CLIENT_GUI, "<html>Nie udało się przesłać wiadmości <br> Server jest: <b>Nieaktywny</b>");
            }
        } else {
            JOptionPane.showMessageDialog(CLIENT_GUI, "Wiadomość nie może być pusta.");
        }
    }
}
