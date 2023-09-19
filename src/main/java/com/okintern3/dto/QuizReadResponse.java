package com.okintern3.dto;

import com.okintern3.entity.Quiz;
import com.okintern3.entity.QuizType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class QuizReadResponse {

    private Long id;

    private String question;

    private List<QuizOptionResponse> options;

    private QuizOptionResponse answer;

    private int answerRate;

    private String answerDescription;

    private QuizType quizType;

    public static QuizReadResponse of(Quiz quiz) {

        List<QuizOptionResponse> options = quiz.getOptions().stream()
                .map(QuizOptionResponse::of)
                .toList();

        QuizOptionResponse answer = options.stream()
                .filter(QuizOptionResponse::isAnswer)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("퀴즈에 정답 선택지가 존재하지 않습니다."));

        return new QuizReadResponse(
                quiz.getId(),
                quiz.getQuestion(),
                options,
                answer,
                -1, // todo: 정답률 계산
                answer.getDesc(),
                quiz.getQuizType()
        );
    }
}
