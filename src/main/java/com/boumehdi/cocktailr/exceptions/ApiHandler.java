package com.boumehdi.cocktailr.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiHandler
{
    // Function called when [throw ApiException] is invoked.
    // This function will create an ExceptionMessage, using ApiException message and status
    // And return and ResponseEntity to the controller
    @ExceptionHandler(value= {ApiException.class})
    public ResponseEntity<Object> handleException(ApiException apiException)
    {
        // Create ExceptionMessage
        ExceptionMessage msg = new ExceptionMessage(apiException.getMessage());

        // Return ResponseEntity (http response)
        return new ResponseEntity<>(msg, apiException.getHttpStatus());
    }

}
