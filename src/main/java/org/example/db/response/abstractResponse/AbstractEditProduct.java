package org.example.db.response.abstractResponse;

import java.net.Socket;

public abstract class AbstractEditProduct {
    protected Socket socket;

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public AbstractEditProduct(Socket socket) {
        this.socket = socket;
    }

    public abstract void edit(String text);
}
