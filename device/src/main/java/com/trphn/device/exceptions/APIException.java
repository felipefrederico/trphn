package com.trphn.device.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;

public class APIException {
    private final String message;
    private final HttpStatus httpStatus;
    private final Instant timestamp;
   
    public APIException(String message, HttpStatus httpStatus, Instant timestamp) {
        this.message = message;
        this.httpStatus = httpStatus;
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

      
}