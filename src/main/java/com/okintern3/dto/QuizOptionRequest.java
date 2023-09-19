package com.okintern3.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class QuizOptionRequest {

    private String text;

    private boolean isAnswer;
}
