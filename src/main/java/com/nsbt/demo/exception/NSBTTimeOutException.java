package com.nsbt.demo.exception;

import java.net.SocketTimeoutException;

/**
 * Identifica las excepciones de tipo timeout para poder manejarlas
 * desde donde se realizan las invocaciones
 */
public class NSBTTimeOutException extends SocketTimeoutException {
    public NSBTTimeOutException() {
        super();
    }

    public NSBTTimeOutException(final String msg) {
        super(msg);
    }

}