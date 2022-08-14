package com.example.myspringproject.ErrorHandling;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String message) {
        super(message);
    }
}