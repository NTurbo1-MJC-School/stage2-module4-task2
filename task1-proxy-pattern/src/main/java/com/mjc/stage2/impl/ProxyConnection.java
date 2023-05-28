package com.mjc.stage2.impl;


import com.mjc.stage2.Connection;

public class ProxyConnection implements Connection {
    private boolean isClosed = true;
    private RealConnection realConnection;
    private ConnectionPool connectionPool = ConnectionPool.getInstance();

    public ProxyConnection(RealConnection realConnection) {
        this.realConnection = realConnection;
        this.isClosed = true;
    }

    public void reallyClose() {
        // Write your code here!
        this.realConnection.close();
        this.isClosed = false;
    }
    // Implement methods here!

    @Override
    public void close() {
        if (this.isClosed) {
            this.reallyClose();
        } else {
            connectionPool.releaseConnection(this);
        }
    }

    @Override
    public boolean isClosed() {
        return this.isClosed;
    }
}
