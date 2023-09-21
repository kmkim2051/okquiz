package com.okintern3.dto;

import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class QuizTakeRequest {

    private Boolean isCorrect;

    public void setIsCorrect(boolean isCorrect) {
        this.isCorrect = isCorrect;
    }
}
