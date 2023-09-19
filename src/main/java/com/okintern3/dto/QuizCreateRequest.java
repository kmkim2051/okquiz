package com.okintern3.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class QuizCreateRequest {

    private String question;

    private String quizType;

    private String category;

    private List<QuizOptionRequest> options;
}
