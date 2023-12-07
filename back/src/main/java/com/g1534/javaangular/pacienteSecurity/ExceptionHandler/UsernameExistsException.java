package com.g1534.javaangular.pacienteSecurity.ExceptionHandler;

public class UsernameExistsException extends RuntimeException {
    public UsernameExistsException(String message) {
        super(message);
    }
}