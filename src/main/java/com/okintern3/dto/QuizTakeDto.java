package com.okintern3.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import com.okintern3.entity.QuizLog;
import com.okintern3.exception.QuizNotFoundException;

@Getter
@AllArgsConstructor
public class QuizTakeDto {
    private Long quizId;

    private boolean isCorrect;

    public QuizLog toEntity() {
        if (quizId == null)
            throw new QuizNotFoundException("QuizId가 명시되지 않았습니다.");

        return new QuizLog(null, quizId, isCorrect);
    }
}
