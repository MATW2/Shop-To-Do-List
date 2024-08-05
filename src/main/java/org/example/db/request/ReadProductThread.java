package org.example.db.request;

import org.example.client.AbstractClientGui;
import org.example.config.HostConfig;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ReadProductThread extends Thread {
    private final AbstractClientGui clientGui;

    public AbstractClientGui getClientGui() {
        return clientGui;
    }

    public ReadProductThread(AbstractClientGui clientGui) {
        this.clientGui = clientGui;
    }

    @Override
    public void run() {
        do {
            if (ConnectionStatus.isConnection()) {
                read();
                break;
            } else {
                int result = JOptionPane.showConfirmDialog(clientGui,
                        "Brak połączenia z bazą danych. Czy chcesz spróbować ponownie?",
                        "Błąd połączenia",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.ERROR_MESSAGE);
                if (result == JOptionPane.NO_OPTION || result == JOptionPane.CLOSED_OPTION) {
                    System.exit(0);
                }
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        } while (true);
    }

    private void read() {
        try (Socket socket = new Socket(HostConfig.getHost(), HostConfig.getPort());
             PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            writer.println("read");
            clientGui.getTableModel().setRowCount(0);
            String line;
            while ((line = reader.readLine()) != null) {
                for (String row : line.split(";")) {
                    String[] studentData = row.split(",");
                    if (!(studentData[0].equals("")))
                        clientGui.getTableModel().addRow(new Object[]{studentData[0], studentData[1], studentData[2], studentData[3]});
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
