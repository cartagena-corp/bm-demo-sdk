package com.nsbt.demo.exception;

public class ConsultarProductosActivosWSException extends BaseException {

    public ConsultarProductosActivosWSException(final Exception cause) {
        super("Ha ocurrido un error al llamar al WS con el mensaje: " + cause.getMessage(), cause);
    }

    public ConsultarProductosActivosWSException(final String msg, final Throwable cause) {
        super(msg, cause);
    }

    public ConsultarProductosActivosWSException(final String msg) {
        super(msg);
    }
}