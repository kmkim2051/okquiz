package com.okintern3.handler;

import com.okintern3.common.ApiResponse;
import com.okintern3.common.ResultStatus;
import com.okintern3.exception.CategoryNotFoundException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CategoryExceptionHandler {

    @ExceptionHandler(CategoryNotFoundException.class)
    public ApiResponse handleCategoryNotFoundException(CategoryNotFoundException ex) {
        return ApiResponse.fail(ResultStatus.CATEGORY_NOT_FOUND);
    }
}
