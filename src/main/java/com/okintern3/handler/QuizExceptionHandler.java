package com.okintern3.handler;

import com.okintern3.common.ApiResponse;
import com.okintern3.exception.AnswerNotFoundException;
import com.okintern3.exception.CategoryNotFoundException;
import com.okintern3.exception.QuizNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class QuizExceptionHandler {

    @ExceptionHandler(AnswerNotFoundException.class)
    public ApiResponse handleNotFoundException(AnswerNotFoundException ex) {
        return ApiResponse.fail(ex.getMessage());
    }

    @ExceptionHandler(CategoryNotFoundException.class)
    public ApiResponse handleNotFoundException(CategoryNotFoundException ex) {
        return ApiResponse.fail(ex.getMessage());
    }

    @ExceptionHandler(QuizNotFoundException.class)
    public ApiResponse handleNotFoundException(QuizNotFoundException ex) {
        return ApiResponse.fail(ex.getMessage());
    }
}
