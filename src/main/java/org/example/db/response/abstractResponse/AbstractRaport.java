package org.example.db.response.abstractResponse;

import java.net.Socket;

public abstract class AbstractRaport {
    protected Socket socket;

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public AbstractRaport(Socket socket) {
        this.socket = socket;
    }

    public abstract void raport(String text);
}
