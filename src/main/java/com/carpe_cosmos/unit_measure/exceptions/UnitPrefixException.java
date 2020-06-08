package com.carpe_cosmos.unit_measure.exceptions;

public class UnitPrefixException extends Exception {
    public UnitPrefixException() {
    }

    public UnitPrefixException(String message) {
        super(message);
    }

    public UnitPrefixException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnitPrefixException(Throwable cause) {
        super(cause);
    }

    public UnitPrefixException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
