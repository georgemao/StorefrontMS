package com;

/**
 * Created by George.Mao on 11/14/2014.
 */
public enum Status {
    SOLD (1), PROCESSED (2);

    private int statusCode;

    private Status(int statusCode) {
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
