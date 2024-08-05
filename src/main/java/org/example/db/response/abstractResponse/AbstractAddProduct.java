package org.example.db.response.abstractResponse;

import java.net.Socket;

public abstract class AbstractAddProduct {
    protected Socket socket;

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public AbstractAddProduct(Socket socket) {
        this.socket = socket;
    }

    public abstract void add(String text);
}
