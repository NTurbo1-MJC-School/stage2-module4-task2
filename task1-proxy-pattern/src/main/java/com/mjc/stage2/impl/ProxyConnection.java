package com.mjc.stage2.impl;


import com.mjc.stage2.Connection;

public class ProxyConnection implements Connection {
    private RealConnection realConnection;
    private ConnectionPool connectionPool = ConnectionPool.getInstance();

    public ProxyConnection(RealConnection realConnection) {
        this.realConnection = realConnection;
    }

    public void reallyClose() {
        // Write your code here!
        this.realConnection.close();
    }
    // Implement methods here!

    @Override
    public void close() {
        connectionPool.releaseConnection(this);
    }

    @Override
    public boolean isClosed() {
        return this.realConnection.isClosed();
    }
}
