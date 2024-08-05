package org.example.client;

import org.example.db.request.*;
import org.example.db.request.AbstractRequest.*;

import java.awt.event.ActionListener;

public abstract class AbstractClientAction implements ActionListener {
    protected final AbstractClientGui CLIENT_GUI;
    protected final AbstractAddProduct ADD_PRODUCT;
    protected final AbstractEditProduct EDIT_PRODUCT;
    protected final AbstractDeleteProduct DELETE_PRODUCT;
    protected final AbstractConnectionStatus CONNECTION_STATUS;
    protected final AbstractRaport RAPORT;

    public AbstractClientGui getCLIENT_GUI() {
        return CLIENT_GUI;
    }

    public AbstractAddProduct getADD_PRODUCT() {
        return ADD_PRODUCT;
    }

    public AbstractEditProduct getEDIT_PRODUCT() {
        return EDIT_PRODUCT;
    }

    public AbstractDeleteProduct getDELETE_PRODUCT() {
        return DELETE_PRODUCT;
    }

    public AbstractConnectionStatus getCONNECTION_STATUS() {
        return CONNECTION_STATUS;
    }

    public AbstractRaport getRAPORT() {
        return RAPORT;
    }

    public AbstractClientAction(AbstractClientGui clientGui) {
        this.CLIENT_GUI = clientGui;
        this.ADD_PRODUCT = new AddProduct(clientGui);
        this.EDIT_PRODUCT = new EditProduct(clientGui);
        this.DELETE_PRODUCT = new DeleteProduct(clientGui);
        this.CONNECTION_STATUS = new ConnectionStatus(clientGui);
        this.RAPORT = new Raport(clientGui);
    }
}
