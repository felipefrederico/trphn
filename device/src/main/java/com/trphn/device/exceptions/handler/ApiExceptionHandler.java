package com.trphn.device.exceptions.handler;

import java.time.Instant;

import com.trphn.device.exceptions.APIException;
import com.trphn.device.exceptions.DeviceNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {
    
    @ExceptionHandler(value = {DeviceNotFoundException.class})
    public ResponseEntity<Object> handleRequestException(DeviceNotFoundException e){
        HttpStatus notFound = HttpStatus.NOT_FOUND;
        APIException apiException = new APIException(e.getMessage(), notFound, Instant.now());
        return new ResponseEntity<>(apiException, notFound);
    }
}