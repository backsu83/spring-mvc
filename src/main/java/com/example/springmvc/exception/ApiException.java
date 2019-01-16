package com.example.springmvc.exception;

public class ApiException extends RuntimeException {
    public ApiException(String message) {
        super(message);
    }
}
