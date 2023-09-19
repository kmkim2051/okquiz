package com.okintern3.controller;

import com.okintern3.common.ApiResponse;
import com.okintern3.dto.QuizReadResponse;
import com.okintern3.service.QuizService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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


}
