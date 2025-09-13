package com.yg.yeohaenggaja.global.common;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@JsonPropertyOrder({"success", "result"})
@RequiredArgsConstructor
public class CommonResponse<T> {

    private final boolean success = true;

    private final T result;

    // 성공 응답
    public static <T> CommonResponse<T> success(T data) {
        return new CommonResponse<>(data);
    }

    // 성공 응답 (데이터 미포함)
    public static <T> CommonResponse<T> success() {
        return new CommonResponse<>(null);
    }
}
