package org.example.db.request.AbstractRequest;

import org.example.client.AbstractClientGui;
import org.example.db.request.ReadProductThread;

public abstract class AbstractDeleteProduct {
    protected final AbstractClientGui clientGui;

    public AbstractClientGui getClientGui() {
        return clientGui;
    }

    public AbstractDeleteProduct(AbstractClientGui clientGui) {
        this.clientGui = clientGui;
    }

    protected void readProduct() {
        new ReadProductThread(clientGui).start();
    }

    public abstract void deleteProduct();

}
