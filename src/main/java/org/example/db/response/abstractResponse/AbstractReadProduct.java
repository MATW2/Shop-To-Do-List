package org.example.db.response.abstractResponse;

import java.net.Socket;

public abstract class AbstractReadProduct {
    protected Socket socket;

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public AbstractReadProduct(Socket socket) {
        this.socket = socket;
    }

    public abstract void read(String text);
}
