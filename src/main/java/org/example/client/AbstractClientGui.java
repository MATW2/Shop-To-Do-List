package org.example.client;

import org.example.db.request.ReadProductThread;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public abstract class AbstractClientGui extends JFrame {
    protected JButton addButton;
    protected JButton editButton;
    protected JButton deleteButton;
    protected JButton raportButton;
    protected JButton connectButton;
    protected JTable table;
    protected DefaultTableModel tableModel;
    protected final AbstractClientAction CLIENT_ACTION;
    protected final Thread READ_PRODUCT;

    public JButton getAddButton() {
        return addButton;
    }

    public JButton getEditButton() {
        return editButton;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }

    public JButton getRaportButton() {
        return raportButton;
    }

    public JButton getConnectButton() {
        return connectButton;
    }

    public JTable getTable() {
        return table;
    }

    public DefaultTableModel getTableModel() {
        return tableModel;
    }

    public AbstractClientAction getCLIENT_ACTION() {
        return CLIENT_ACTION;
    }

    public Thread getREAD_PRODUCT() {
        return READ_PRODUCT;
    }

    public void setAddButton(JButton addButton) {
        this.addButton = addButton;
    }

    public void setEditButton(JButton editButton) {
        this.editButton = editButton;
    }

    public void setDeleteButton(JButton deleteButton) {
        this.deleteButton = deleteButton;
    }

    public void setRaportButton(JButton raportButton) {
        this.raportButton = raportButton;
    }

    public void setConnectButton(JButton connectButton) {
        this.connectButton = connectButton;
    }

    public void setTable(JTable table) {
        this.table = table;
    }

    public void setTableModel(DefaultTableModel tableModel) {
        this.tableModel = tableModel;
    }

    public AbstractClientGui(String title) {
        setTitle(title);
        READ_PRODUCT = new ReadProductThread(this);
        CLIENT_ACTION = new ClientAction(this);
    }

    public abstract void initWindow();
}
