package com.okintern3.service;

import com.okintern3.dto.QuizCreateRequest;
import com.okintern3.dto.QuizReadResponse;
import com.okintern3.dto.QuizTakeRequest;

import java.util.List;

public interface QuizService {

    void createQuiz(QuizCreateRequest request);

    List<QuizReadResponse> getQuizzesByCategoryName(String categoryName);

    void takeQuiz(QuizTakeRequest request);
}
