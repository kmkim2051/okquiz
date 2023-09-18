package com.okintern3.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class QuizCreateRequest {

    private String question;

    private String quizType;

    private String category;

    private List<QuizOptionRequest> options;
}
