package org.example.config;

import org.example.db.response.*;
import org.example.db.response.abstractResponse.*;

import java.net.Socket;

public class ServerConfig extends Thread {
    protected final Socket socket;
    protected final AbstractReadProduct READ_PRODUCT;
    protected final AbstractAddProduct ADD_PRODUCT;
    protected final AbstractEditProduct EDIT_PRODUCT;
    protected final AbstractDeleteProduct DELETE_PRODUCT;
    protected final AbstractRaport RAPORT;
    protected final AbstractConnectionStatus CONNECTION_STATUS;

    public Socket getSocket() {
        return socket;
    }

    public AbstractReadProduct getREAD_PRODUCT() {
        return READ_PRODUCT;
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

    public AbstractRaport getRAPORT() {
        return RAPORT;
    }

    public AbstractConnectionStatus getCONNECTION_STATUS() {
        return CONNECTION_STATUS;
    }

    public ServerConfig(Socket socket) {
        this.socket = socket;
        this.READ_PRODUCT = new ReadProduct(socket);
        this.ADD_PRODUCT = new AddProduct(socket);
        this.EDIT_PRODUCT = new EditProduct(socket);
        this.DELETE_PRODUCT = new DeleteProduct(socket);
        this.RAPORT = new Raport(socket);
        this.CONNECTION_STATUS = new ConnectionStatus(socket);
    }
}
