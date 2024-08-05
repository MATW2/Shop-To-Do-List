package org.example.db.request;

import org.example.client.AbstractClientGui;
import org.example.config.HostConfig;
import org.example.db.request.AbstractRequest.AbstractAddProduct;
import org.example.validation.ProductValidator;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class AddProduct extends AbstractAddProduct {

    public AddProduct(AbstractClientGui clientGui) {
        super(clientGui);
    }

    @Override
    public void addProduct() {
        try (Socket socket = new Socket(HostConfig.getHost(), HostConfig.getPort());
             PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            if (ConnectionStatus.isConnection()) {
                String name = ProductValidator.validateName("", "nazwę", clientGui);
                if (name == null) return;

                String quantity = ProductValidator.validateQuantity("", "ilość", clientGui);
                if (quantity == null) return;

                String price = ProductValidator.validatePrice("", "cene", clientGui);
                if (price == null) return;

                writer.println("add" + ";" + name + ";" + quantity + ";" + price);
                JOptionPane.showMessageDialog(clientGui, reader.readLine());
                READ_PRODUCT.start();
            } else {
                JOptionPane.showMessageDialog(clientGui, "<html>Baza danych jest: <b>Nieaktywna</b> <br> Nie udało się połąnczyć.</html>");
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(clientGui, "<html>Serwer jest: <b>Nieaktywny</b> <br> Nie udało się połąnczyć.</html> ");
        }
    }
}
