package org.example.db.request.AbstractRequest;

import org.example.client.AbstractClientGui;
import org.example.db.request.ReadProductThread;

public abstract class AbstractDeleteProduct {
    protected final AbstractClientGui clientGui;
    protected final Thread READ_PRODUCT;

    public AbstractClientGui getClientGui() {
        return clientGui;
    }

    public Thread getREAD_PRODUCT() {
        return READ_PRODUCT;
    }

    public AbstractDeleteProduct(AbstractClientGui clientGui) {
        this.clientGui = clientGui;
        this.READ_PRODUCT = new ReadProductThread(clientGui);
    }

    public abstract void deleteProduct();

}
