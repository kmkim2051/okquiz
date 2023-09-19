package com.okintern3.service;

import com.okintern3.dto.QuizCreateRequest;
import com.okintern3.dto.QuizReadResponse;
import com.okintern3.dto.QuizTakeRequest;
import com.okintern3.entity.Category;
import com.okintern3.entity.QuizLog;
import com.okintern3.exception.CategoryNotFoundException;
import com.okintern3.exception.QuizNotFoundException;
import com.okintern3.repository.CategoryRepository;
import com.okintern3.repository.QuizLogRepository;
import com.okintern3.repository.QuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class QuizServiceImpl implements QuizService {

    private final CategoryRepository categoryRepository;

    private final QuizRepository quizRepository;

    private final QuizLogRepository quizLogRepository;

    @Override
    @Transactional
    public void createQuiz(QuizCreateRequest request) {
        // quiz Option에 answer는 최소 하나 있어야함
    }

    @Override
    @Transactional(readOnly = true)
    public List<QuizReadResponse> getQuizzesByCategoryName(String categoryName) {

        final int NUMBER_OF_QUIZ_IN_TEST = 15;

        // todo: 공통 예외처리
        final Category category = categoryRepository
                .findByName(categoryName)
                .orElseThrow(() -> new CategoryNotFoundException("존재하지 않는 카테고리 이름입니다."));

        Random random = new Random();

        return quizRepository.findByCategory(category)
                .stream()
                .sorted((a, b) -> random.nextInt(3) - 1)
                .limit(NUMBER_OF_QUIZ_IN_TEST)
                .map(QuizReadResponse::of)
                .peek(quizResponse -> {
                    final double ratio = quizLogRepository.calculateAnswerRatio(quizResponse.getId());
                    quizResponse.setAnswerRate((int) Math.round(ratio * 100));
                })
                .toList();
    }

    @Override
    @Transactional
    public void takeQuiz(QuizTakeRequest request) {
        Long quizId = request.getQuizId();
        quizRepository.findById(quizId)
                .orElseThrow(() -> new QuizNotFoundException("존재하지 않는 퀴즈 id입니다."));
        // 퀴즈 응시
        quizLogRepository.save(request.toEntity());
    }
}
