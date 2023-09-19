package com.okintern3.controller;

import com.okintern3.common.ApiResponse;
import com.okintern3.dto.QuizReadResponse;
import com.okintern3.dto.QuizTakeRequest;
import com.okintern3.service.QuizService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class QuizController {

    private final QuizService quizService;

    @GetMapping("/{category}/test")
    public ApiResponse<List<QuizReadResponse>> takeTest(@PathVariable String category) {
        List<QuizReadResponse> quizzes = quizService.getQuizzesByCategoryName(category);
        return ApiResponse.success(quizzes);
    }

    @PostMapping("/{category}/test/quiz")
    public ApiResponse solveQuiz(@RequestBody QuizTakeRequest quizTakeRequest) {
        quizService.takeQuiz(quizTakeRequest);
        return ApiResponse.success();
    }
}
