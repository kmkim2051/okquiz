package com.okintern3.dto;

import com.okintern3.entity.QuizOption;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class QuizOptionResponse {

    private long id;

    private String text;

    private boolean isAnswer;

    private String desc;

    public boolean getIsAnswer() {
        return this.isAnswer;
    }

    public static QuizOptionResponse of(QuizOption quizOption) {
        return new QuizOptionResponse(
                quizOption.getId(),
                quizOption.getContent(),
                quizOption.isAnswer(),
                quizOption.getDescription()
        );
    }
}
