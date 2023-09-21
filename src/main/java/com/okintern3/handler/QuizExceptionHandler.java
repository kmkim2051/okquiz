package com.okintern3.handler;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.okintern3.common.ApiResponse;
import com.okintern3.common.ResultStatus;
import com.okintern3.exception.AnswerNotFoundException;
import com.okintern3.exception.QuizNotFoundException;

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class QuizExceptionHandler {

    @ExceptionHandler(AnswerNotFoundException.class)
    public ApiResponse handleAnswerNotFoundException(AnswerNotFoundException ex) {
        return ApiResponse.fail(ResultStatus.ANSWER_OPTION_NOT_FOUND);
    }

    @ExceptionHandler(QuizNotFoundException.class)
    public ApiResponse handleQuizNotFoundException(QuizNotFoundException ex) {
        return ApiResponse.fail(ResultStatus.QUIZ_NOT_FOUND);
    }
}
