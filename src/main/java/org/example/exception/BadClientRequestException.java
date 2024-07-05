package org.example.exception;

public class BadClientRequestException extends RuntimeException{
    public BadClientRequestException() {
        super("Client cannot be null");
    }
}
