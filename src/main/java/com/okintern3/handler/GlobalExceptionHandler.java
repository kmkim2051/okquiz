package com.okintern3.handler;

import com.okintern3.common.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    // Handle all unhandled exceptions
    @ExceptionHandler(Exception.class)
    public ApiResponse handleAllExceptions(Exception ex) {
        // You can log the exception here for debugging purposes
        ex.printStackTrace();

        // Return a generic error response
        return ApiResponse.fail(HttpStatus.INTERNAL_SERVER_ERROR.toString());
    }
}