package com.okintern3.common;

import lombok.Getter;

@Getter
public enum ResultStatus {
    SUCCESS("성공"),
    FAIL("실패");

    private final String message;

    ResultStatus(String message) {
        this.message = message;
    }

}
