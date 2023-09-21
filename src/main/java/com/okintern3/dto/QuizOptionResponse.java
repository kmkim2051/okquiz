package com.okintern3.dto;

import lombok.Getter;
import lombok.AllArgsConstructor;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.okintern3.entity.QuizOption;

@Getter
@AllArgsConstructor
public class QuizOptionResponse {

    private long id;

    @JsonProperty("text")
    private String content;

    private boolean isAnswer;

    private String description;

    public boolean getIsAnswer() {
        return this.isAnswer;
    }

    public static QuizOptionResponse of(QuizOption quizOption) {
        return new QuizOptionResponse(
                quizOption.getId(),
                quizOption.getContent(),
                quizOption.getIsAnswer(),
                quizOption.getDescription()
        );
    }
}
