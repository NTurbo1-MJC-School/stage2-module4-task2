package com.mjc.stage2.impl;


import com.mjc.stage2.Connection;

public class ProxyConnection implements Connection {
    private boolean isClosed = false;
    private RealConnection realConnection;
    private ConnectionPool connectionPool = ConnectionPool.getInstance();

    public ProxyConnection(RealConnection realConnection) {
        this.realConnection = realConnection;
    }

    public void reallyClose() {
        // Write your code here!
        if (!isClosed) {
            this.realConnection.close();
            isClosed = true;
        }
    }
    // Implement methods here!

    @Override
    public void close() {
        if (!isClosed) {
            connectionPool.releaseConnection(this);
        }
    }

    @Override
    public boolean isClosed() {
        return isClosed;
    }
}
