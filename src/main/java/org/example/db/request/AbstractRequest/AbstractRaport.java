package org.example.db.request.AbstractRequest;

import org.example.client.AbstractClientGui;

public abstract class AbstractRaport {
    protected final AbstractClientGui CLIENT_GUI;

    public AbstractClientGui getCLIENT_GUI() {
        return CLIENT_GUI;
    }

    public AbstractRaport(AbstractClientGui clientGui) {
        this.CLIENT_GUI = clientGui;
    }

    public abstract void report();
}
