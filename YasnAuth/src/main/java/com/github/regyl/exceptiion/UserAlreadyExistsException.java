package com.github.regyl.exceptiion;

import org.springframework.security.core.AuthenticationException;

public class UserAlreadyExistsException extends AuthenticationException {

    private static final String PREFIX = "User already exists exception: ";

    public UserAlreadyExistsException(String message) {
        super(PREFIX + message);
    }
}
