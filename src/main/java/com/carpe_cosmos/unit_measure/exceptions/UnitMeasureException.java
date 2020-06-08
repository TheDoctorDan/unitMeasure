package com.carpe_cosmos.unit_measure.exceptions;

public class UnitMeasureException extends Exception {

    public UnitMeasureException(String message) {
        super(message);
    }

    public UnitMeasureException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnitMeasureException(Throwable cause) {
        super(cause);
    }

    public UnitMeasureException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
