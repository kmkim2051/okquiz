package com.okintern3.dto;

import lombok.*;
import com.fasterxml.jackson.annotation.JsonProperty;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class QuizOptionRequest {

    @JsonProperty("text")
    private String content;

    private boolean isAnswer;

    private String description;

    public void setIsAnswer(boolean isAnswer) {
        this.isAnswer = isAnswer;
    }
}
