package com.okintern3.common;

import lombok.Getter;
import java.util.List;

@Getter
public class ApiResponse<T> {

    private final T data;

    private final ResultStatus status;

    private final String message;

    private ApiResponse(T data, ResultStatus status, String message) {
        this.data = data;
        this.status = status;
        this.message = message;
    }

    public static <T> ApiResponse<T> success() {
        return new ApiResponse<>(
                null, ResultStatus.SUCCESS,ResultStatus.SUCCESS.getMessage()
        );
    }

    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(
                data, ResultStatus.SUCCESS,ResultStatus.SUCCESS.getMessage()
        );
    }

    public static <T> ApiResponse<List<T>> success(List<T> data) {
        return new ApiResponse<>(
                data, ResultStatus.SUCCESS,ResultStatus.SUCCESS.getMessage()
        );
    }

    public static <T> ApiResponse<T> fail() {
        return new ApiResponse<>(
                null, ResultStatus.FAIL, ResultStatus.FAIL.getMessage()
        );
    }

    public static <T> ApiResponse<T> fail(String message) {
        return new ApiResponse<>(
                null, ResultStatus.FAIL, message
        );
    }
}
