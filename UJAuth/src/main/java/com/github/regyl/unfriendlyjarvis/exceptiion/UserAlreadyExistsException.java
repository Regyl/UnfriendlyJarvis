package com.github.regyl.unfriendlyjarvis.exceptiion;

import org.springframework.security.core.AuthenticationException;

/**
 * Exception for attempt to create user with busy username.
 */
public class UserAlreadyExistsException extends AuthenticationException {

    private static final String PREFIX = "User already exists: ";

    /**
     * Constructor.
     *
     * @param message requested username
     */
    public UserAlreadyExistsException(String message) {
        super(PREFIX + message);
    }
}
