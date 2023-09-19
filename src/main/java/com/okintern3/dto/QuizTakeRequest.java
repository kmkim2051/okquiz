package com.okintern3.dto;

import com.okintern3.entity.QuizLog;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class QuizTakeRequest {

    private Long quizId;

    private Boolean isCorrect;

    public QuizLog toEntity() {
        return new QuizLog(null, quizId, isCorrect);
    }
}
