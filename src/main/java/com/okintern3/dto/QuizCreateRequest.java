package com.okintern3.dto;

import java.util.List;

import lombok.*;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.okintern3.entity.QuizType;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class QuizCreateRequest {

    @JsonProperty("category")
    private String categoryName;

    private String question;

    private QuizType quizType;

    private List<QuizOptionRequest> options;
}
