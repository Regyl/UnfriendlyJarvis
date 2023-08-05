package com.github.regyl.exceptiion;

/**
 * Base application exception.
 */
public class JarvisException extends RuntimeException {

    /**
     * Inherited constructor from message.
     *
     * @param message exception message
     */
    public JarvisException(String message) {
        super(message);
    }
}
