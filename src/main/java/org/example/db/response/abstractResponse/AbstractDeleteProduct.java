package org.example.db.response.abstractResponse;

import java.net.Socket;

public abstract class AbstractDeleteProduct {
    protected Socket socket;

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public AbstractDeleteProduct(Socket socket) {
        this.socket = socket;
    }

    public abstract void delete(String text);
}
