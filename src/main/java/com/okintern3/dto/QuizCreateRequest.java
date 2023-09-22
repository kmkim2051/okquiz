package com.okintern3.dto;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import lombok.*;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.okintern3.entity.QuizType;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class QuizCreateRequest {

    @JsonProperty("category")
    @NotBlank
    private String categoryName;

    @NotBlank
    private String question;

    @NotNull
    private QuizType quizType;

    @Valid
    @NotEmpty(message = "option은 하나 이상 존재해야 합니다.")
    private List<QuizOptionRequest> options;
}
