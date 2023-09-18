package com.okintern3.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class QuizTakeRequest {

    private Long id;

    private Boolean isCorrect;
}
