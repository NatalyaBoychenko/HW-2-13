package org.example.exception;

public class BadPlanetRequestException extends RuntimeException{
    public BadPlanetRequestException() {
        super("Planet cannot be null");
    }
}
