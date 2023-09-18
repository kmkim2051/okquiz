package com.okintern3.dto;

import com.okintern3.entity.QuizOption;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class QuizOptionResponse {

    private long id;

    private String text;

    private boolean isAnswer;

    private String description;

    public static QuizOptionResponse of(QuizOption quizOption) {
        return new QuizOptionResponse(
                quizOption.getId(),
                quizOption.getText(),
                quizOption.isAnswer(),
                quizOption.getDescription()
        );
    }
}