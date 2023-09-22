package com.okintern3.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import lombok.*;
import com.fasterxml.jackson.annotation.JsonProperty;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class QuizOptionRequest {

    @JsonProperty("text")
    @NotBlank
    private String content;

    @NotNull
    private Boolean isAnswer;

    private String description; // nullable

    public void setIsAnswer(Boolean isAnswer) {
        this.isAnswer = isAnswer;
    }
}
