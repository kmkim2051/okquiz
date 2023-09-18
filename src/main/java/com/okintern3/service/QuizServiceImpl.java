package com.okintern3.service;

import com.okintern3.dto.QuizCreateRequest;
import com.okintern3.dto.QuizReadResponse;
import com.okintern3.dto.QuizTakeRequest;
import com.okintern3.entity.Category;
import com.okintern3.repository.CategoryRepository;
import com.okintern3.repository.QuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuizServiceImpl implements QuizService {

    private final CategoryRepository categoryRepository;

    private final QuizRepository quizRepository;

    @Override
    @Transactional
    public void createQuiz(QuizCreateRequest request) {
        // quiz Option에 answer는 최소 하나 있어야함
    }

    @Override
    @Transactional(readOnly = true)
    public List<QuizReadResponse> getQuizzesByCategoryName(String categoryName) {
        // todo: 공통 예외처리
        final Category category = categoryRepository
                .findByName(categoryName)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 카테고리 이름입니다."));

        List<QuizReadResponse> quizReadResponses = quizRepository.findByCategory(category)
                .stream()
                .map(QuizReadResponse::of)
                .toList();

        // todo: 정답률 주입하기(아마 JPQL)

        return quizReadResponses;
    }

    @Override
    @Transactional
    public void takeQuiz(QuizTakeRequest request) {
        // 퀴즈 응시
    }
}
