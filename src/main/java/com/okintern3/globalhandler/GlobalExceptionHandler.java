package com.okintern3.globalhandler;

import com.okintern3.common.ApiResponse;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ApiResponse handleAllExceptions(Exception ex) {
        ex.printStackTrace();

        return ApiResponse.error(HttpStatus.INTERNAL_SERVER_ERROR.toString());
    }
}