package org.example.db.request.AbstractRequest;

import org.example.client.AbstractClientGui;
import org.example.db.request.ReadProductThread;

public abstract class AbstractAddProduct {
    protected final AbstractClientGui clientGui;

    public AbstractClientGui getClientGui() {
        return clientGui;
    }

    public AbstractAddProduct(AbstractClientGui clientGui) {
        this.clientGui = clientGui;
    }

    protected void readProduct() {
        new ReadProductThread(clientGui).start();
    }

    public abstract void addProduct();
}
