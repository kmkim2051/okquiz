package com.okintern3.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

import com.okintern3.common.ApiResponse;
import com.okintern3.dto.QuizCreateRequest;
import com.okintern3.dto.QuizReadResponse;
import com.okintern3.dto.QuizTakeDto;
import com.okintern3.dto.QuizTakeRequest;
import com.okintern3.service.QuizService;

@RestController
@RequiredArgsConstructor
public class QuizController {

    private final QuizService quizService;

    @GetMapping("/{category}/test")
    public ApiResponse<List<QuizReadResponse>> takeTest(@PathVariable String category) {
        List<QuizReadResponse> quizzes = quizService.getQuizzesByCategoryName(category);
        return ApiResponse.success(quizzes);
    }

    @PostMapping("/test/quizzes/{quizId}")
    public ApiResponse solveQuiz(@PathVariable("quizId") Long quizId, @RequestBody QuizTakeRequest quizTakeRequest) {
        QuizTakeDto quizTakeDto = new QuizTakeDto(quizId, quizTakeRequest.getIsCorrect());

        quizService.takeQuiz(quizTakeDto);
        return ApiResponse.success();
    }

    @PostMapping("/quizzes")
    public ApiResponse makeQuiz(@RequestBody QuizCreateRequest quizCreateRequest) {
        quizService.createQuiz(quizCreateRequest);
        return ApiResponse.success();
    }

}
