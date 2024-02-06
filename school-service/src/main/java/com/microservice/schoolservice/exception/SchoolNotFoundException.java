package com.microservice.schoolservice.exception;

public class SchoolNotFoundException extends RuntimeException {
    public SchoolNotFoundException(String msg) {
        super(msg);
    }
}
