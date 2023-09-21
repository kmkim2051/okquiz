package com.okintern3.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class QuizTakeRequest {

    @NotNull
    private Boolean isCorrect;

    public void setIsCorrect(boolean isCorrect) {
        this.isCorrect = isCorrect;
    }
}
