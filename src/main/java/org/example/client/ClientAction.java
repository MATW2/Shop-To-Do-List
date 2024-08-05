package org.example.client;

import java.awt.event.ActionEvent;

public class ClientAction extends AbstractClientAction{

    public ClientAction(AbstractClientGui clientGui) {
        super(clientGui);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == CLIENT_GUI.addButton) ADD_PRODUCT.addProduct();
        if (e.getSource() == CLIENT_GUI.editButton) EDIT_PRODUCT.editProduct();
        if (e.getSource() == CLIENT_GUI.connectButton) CONNECTION_STATUS.status();
        if (e.getSource() == CLIENT_GUI.raportButton) RAPORT.report();
        if (e.getSource() == CLIENT_GUI.deleteButton) DELETE_PRODUCT.deleteProduct();
    }
}
