package org.example.api.exceptions;

public class ServiceNotAvailableException extends Exception{
    public ServiceNotAvailableException(String message) {
        super(message);
    }
}
