package com.trphn.device.exceptions;

public class DeviceNotFoundException extends RuntimeException {

    private String message;
    public DeviceNotFoundException(String message) {
        super(message);
        this.message = message;
    }
    public DeviceNotFoundException(String message, Throwable cause) {
    }
    
}
