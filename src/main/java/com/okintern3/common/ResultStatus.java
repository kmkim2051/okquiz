package com.okintern3.common;

import lombok.Getter;

@Getter
public enum ResultStatus {
    // 기본
    SUCCESS("성공"),
    FAIL("실패"),
    ERROR("서버 에러"),

    // 커스텀 에러
    CATEGORY_NOT_FOUND("카테고리가 존재하지 않습니다."),
    QUIZ_NOT_FOUND("퀴즈가 존재하지 않습니다."),
    ANSWER_OPTION_NOT_FOUND("정답 선택지가 존재하지 않습니다."),
    INVALID_QUIZ_OPTION("퀴즈 선택지의 수가 올바르지 않습니다.");

    private final String message;

    ResultStatus(String message) {
        this.message = message;
    }
}
