package com.github.regyl.exceptiion;

/**
 * Default application exception.
 */
public class JarvisException extends RuntimeException {

    /**
     * Inherited constructor from message.
     * @param message exception message
     */
    public JarvisException(String message) {
        super(message);
    }
}
