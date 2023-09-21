package com.okintern3.service;

import java.util.List;
import java.util.Random;

import com.okintern3.dto.*;
import com.okintern3.exception.AnswerNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

import com.okintern3.entity.Category;
import com.okintern3.entity.Quiz;
import com.okintern3.entity.QuizOption;
import com.okintern3.exception.CategoryNotFoundException;
import com.okintern3.exception.QuizNotFoundException;
import com.okintern3.repository.CategoryRepository;
import com.okintern3.repository.QuizLogRepository;
import com.okintern3.repository.QuizRepository;
import com.okintern3.entity.QuizType;
import com.okintern3.exception.InvalidQuizOptionException;

@Service
@RequiredArgsConstructor
public class QuizServiceImpl implements QuizService {

    private final CategoryRepository categoryRepository;

    private final QuizRepository quizRepository;

    private final QuizLogRepository quizLogRepository;

    private void validateNumberOfOptionsForQuizType(QuizCreateRequest request) {
        QuizType quizType = request.getQuizType();
        int numberOfOptions = request.getOptions().size();

        if ((quizType.equals(QuizType.OX)) && (numberOfOptions != 2)) {
            throw new InvalidQuizOptionException("OX퀴즈의 선택지는 2개여야 합니다.");
        }

        if ((quizType.equals(QuizType.MULTI_OPTION)) && (numberOfOptions < 2)) {
            throw new InvalidQuizOptionException("다지선다 퀴즈의 선택지는 2개 이상이어야 합니다.");
        }

        // 단답형 퀴즈는 복수 정답 인정을 위해 답이 여러 개일 수 있어 유효성 검사 로직이 애매하여 추가하지 않았음
    }

    private void validateQuizContent(QuizCreateRequest request) {
        QuizType quizType = request.getQuizType();
        List<QuizOptionRequest> options = request.getOptions();

        if (quizType.equals(QuizType.OX)) {
            List<String> contents = options.stream()
                    .map(QuizOptionRequest::getContent)
                    .map(String::toUpperCase)
                    .toList();
            if (!(contents.contains("O") && contents.contains("X"))) {
                throw new InvalidQuizOptionException("OX 퀴즈의 선택지는 O와 X를 모두 포함해야 합니다.");
            }
        }

        options.stream()
                .filter(QuizOptionRequest::getIsAnswer)
                .findFirst()
                .orElseThrow(() -> new AnswerNotFoundException("퀴즈에 정답 선택지가 존재하지 않습니다."));
    }

    @Override
    @Transactional
    public void createQuiz(QuizCreateRequest request) {
        Category category = categoryRepository.findByName(request.getCategoryName())
                .orElseThrow(() -> new CategoryNotFoundException("존재하지 않는 카테고리 이름입니다."));

        validateNumberOfOptionsForQuizType(request);
        validateQuizContent(request);

        Quiz quiz = new Quiz(
                request.getQuestion(),
                category,
                request.getQuizType());

        request.getOptions()
                .forEach(option -> new QuizOption(
                        option.getContent(),
                        option.getIsAnswer(),
                        quiz,
                        option.getDescription()
                ));

        quizRepository.save(quiz);
    }

    @Override
    @Transactional(readOnly = true)
    public List<QuizReadResponse> getQuizzesByCategoryName(String categoryName) {

        final int NUMBER_OF_QUIZ_IN_TEST = 15;

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
