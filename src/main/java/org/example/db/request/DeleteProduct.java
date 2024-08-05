package org.example.db.request;

import org.example.client.AbstractClientGui;
import org.example.config.HostConfig;
import org.example.db.request.AbstractRequest.AbstractDeleteProduct;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class DeleteProduct extends AbstractDeleteProduct {

    public DeleteProduct(AbstractClientGui clientGui) {
        super(clientGui);
    }

    @Override
    public void deleteProduct() {
        int selectedRow = clientGui.getTable().getSelectedRow();
        if (selectedRow != -1) {
            try (Socket socket = new Socket(HostConfig.getHost(), HostConfig.getPort());
                 PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
                 BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                if (ConnectionStatus.isConnection()) {
                    String id = (String) clientGui.getTable().getValueAt(selectedRow, 0);
                    String name = (String) clientGui.getTable().getValueAt(selectedRow, 1);
                    writer.println("delete" + ";" + id );
                    JOptionPane.showMessageDialog(clientGui, reader.readLine() + name);
                    readProduct();
                } else {
                    JOptionPane.showMessageDialog(clientGui, "<html>Baza danych jest: <b>Nieaktywna</b> <br> Nie udało się połąnczyć.</html>");
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(clientGui, "<html>Serwer jest: <b>Nieaktywny</b> <br> Nie udało się połąnczyć.</html> ");
            }
        } else {
            JOptionPane.showMessageDialog(clientGui, "Nie zaznaczono żadnego rekordu.");
        }
    }
}
