package com.thinkconstructive.restapplication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CloudVendorExceptionHandler {

    @ExceptionHandler(value = {CloudVendorNotFoundException.class})
    public ResponseEntity<Object> handleCloudVendorNotFoundException(CloudVendorNotFoundException cloudVendorNotFoundException){

        CloudVendorException cloudVendorException = new CloudVendorException(cloudVendorNotFoundException.getMessage(),
                HttpStatus.NOT_FOUND, cloudVendorNotFoundException.getCause());

        return new ResponseEntity<>(cloudVendorException, HttpStatus.NOT_FOUND);
    }
}
