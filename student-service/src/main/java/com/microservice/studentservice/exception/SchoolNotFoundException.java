package com.microservice.studentservice.exception;

public class SchoolNotFoundException extends RuntimeException {
    private ExceptionMessage exceptionMessage;

    public SchoolNotFoundException(String message) {
        super(message);
    }

    public SchoolNotFoundException(ExceptionMessage message) {
        this.exceptionMessage = message;
    }

    public SchoolNotFoundException(String message, ExceptionMessage exceptionMessage) {
        super(message);
        this.exceptionMessage = exceptionMessage;
    }

    public ExceptionMessage getExceptionMessage() {
        return exceptionMessage;
    }
}
