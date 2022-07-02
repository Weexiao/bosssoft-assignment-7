
package com.example.springcloudprovider8081.exception;

public class CustomRuntimeException extends RuntimeException {
    public CustomRuntimeException(String msg) {
        super(msg);
    }
}
