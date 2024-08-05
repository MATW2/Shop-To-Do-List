package org.example.client;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ClientGui extends AbstractClientGui {

    public ClientGui() {
        super("Sklep");
        initWindow();
    }

    @Override
    public void initWindow() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 400);
        init();
        initTable();
        addToPanel();
        style();
        setAction();
        setVisible(true);
    }

    private void init() {
        addButton = new JButton("Dodaj");
        editButton = new JButton("Edytuj");
        deleteButton = new JButton("Usuń");
        connectButton = new JButton("Sprawdź połączenie");
        raportButton = new JButton("Dodaj report");
        table = new JTable();
        tableModel = new DefaultTableModel();
        table.setModel(tableModel);
    }

    private void setAction() {
        addButton.addActionListener(CLIENT_ACTION);
        editButton.addActionListener(CLIENT_ACTION);
        deleteButton.addActionListener(CLIENT_ACTION);
        connectButton.addActionListener(CLIENT_ACTION);
        raportButton.addActionListener(CLIENT_ACTION);
    }

    private void initTable() {
        tableModel.addColumn("#");
        tableModel.addColumn("Nazwa");
        tableModel.addColumn("Ilość");
        tableModel.addColumn("Cena");
        READ_PRODUCT.start();
    }

    private void addToPanel() {
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.TRAILING));
        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(connectButton);
        buttonPanel.add(raportButton);
        getContentPane().add(buttonPanel, BorderLayout.NORTH);
        getContentPane().add(new JScrollPane(table), BorderLayout.CENTER);
    }

    private void style() {
        addButton.setFocusable(false);
        editButton.setFocusable(false);
        connectButton.setFocusable(false);
        raportButton.setFocusable(false);
    }

    public static void main(String[] args) {
        new ClientGui();
    }
}
