package com.github.regyl.unfriendlyjarvis.exception;

public class JarvisException extends RuntimeException {

    public JarvisException() {
    }

    public JarvisException(String message) {
        super(message);
    }

    public JarvisException(String message, Throwable cause) {
        super(message, cause);
    }

    public JarvisException(Throwable cause) {
        super(cause);
    }

    public JarvisException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
