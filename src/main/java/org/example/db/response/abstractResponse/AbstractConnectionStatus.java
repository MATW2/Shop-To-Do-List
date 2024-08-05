package org.example.db.response.abstractResponse;

import java.net.Socket;

public abstract class AbstractConnectionStatus {
    protected Socket socket;

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public AbstractConnectionStatus(Socket socket) {
        this.socket = socket;
    }

    public abstract void status();
}
