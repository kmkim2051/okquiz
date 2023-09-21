package com.okintern3.service;

import java.util.List;

import com.okintern3.dto.QuizCreateRequest;
import com.okintern3.dto.QuizReadResponse;
import com.okintern3.dto.QuizTakeDto;

public interface QuizService {

    void createQuiz(QuizCreateRequest request);

    List<QuizReadResponse> getQuizzesByCategoryName(String categoryName);

    void takeQuiz(QuizTakeDto quizTakeDto);
}
