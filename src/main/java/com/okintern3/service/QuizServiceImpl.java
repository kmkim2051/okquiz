package com.okintern3.service;

import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

import com.okintern3.dto.QuizCreateRequest;
import com.okintern3.dto.QuizReadResponse;
import com.okintern3.dto.QuizTakeDto;
import com.okintern3.entity.Category;
import com.okintern3.entity.Quiz;
import com.okintern3.entity.QuizOption;
import com.okintern3.exception.CategoryNotFoundException;
import com.okintern3.exception.QuizNotFoundException;
import com.okintern3.repository.CategoryRepository;
import com.okintern3.repository.QuizLogRepository;
import com.okintern3.repository.QuizRepository;

@Service
@RequiredArgsConstructor
public class QuizServiceImpl implements QuizService {

    private final CategoryRepository categoryRepository;

    private final QuizRepository quizRepository;

    private final QuizLogRepository quizLogRepository;

    @Override
    @Transactional
    public void createQuiz(QuizCreateRequest request) {
        Category category = categoryRepository.findByName(request.getCategoryName())
                .orElseThrow(() -> new CategoryNotFoundException("존재하지 않는 카테고리 이름입니다."));

        Quiz quiz = new Quiz(
                request.getQuestion(),
                category,
                request.getQuizType());

        request.getOptions()
                .forEach(option -> new QuizOption(
                        option.getContent(),
                        option.isAnswer(),
                        quiz,
                        option.getDescription()
                ));

        quizRepository.save(quiz);
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
    public void takeQuiz(QuizTakeDto quizTakeDto) {
        quizRepository.findById(quizTakeDto.getQuizId())
                .orElseThrow(() -> new QuizNotFoundException("존재하지 않는 퀴즈 id입니다."));
        // 퀴즈 응시
        quizLogRepository.save(quizTakeDto.toEntity());
    }
}
