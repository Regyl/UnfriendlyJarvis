package com.github.regyl.exceptiion;

public class UserAlreadyExistsException extends RuntimeException {

    private static final String PREFIX = "User already exists exception: ";

    public UserAlreadyExistsException(String message) {
        super(PREFIX + message);
    }
}
