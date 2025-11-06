package com.nsbt.demo.exception;

public class BaseException extends RuntimeException {
    public BaseException(final String msg) {
        super(msg);
    }

    public BaseException(final String msg, final Throwable cause) {
        super(msg, cause);
    }
}