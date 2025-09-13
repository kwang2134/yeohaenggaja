package com.yg.yeohaenggaja.global.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {
    // 시스템
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "서버 오류가 발생했습니다."),
    BAD_REQUEST(HttpStatus.BAD_REQUEST, "유효하지 않은 요청입니다."),

    // 추천 로직
    MISSING_FILTER_CONDITIONS(HttpStatus.BAD_REQUEST, "추천을 위한 조건이 최소 하나는 필요합니다."),

    // 여행지
    TRAVELSPOT_NOT_FOUND(HttpStatus.NOT_FOUND, "해당 여행지가 존재하지 않습니다.");

    private final HttpStatus httpStatus;
    private final String message;

    ErrorCode(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }

    public AppException serviceException() {
        return new AppException(this, ErrorType.SERVICE);
    }

    public AppException serviceException(String detail) {
        return new AppException(this, detail, ErrorType.SERVICE);
    }

    public AppException domainException() {return new AppException(this, ErrorType.DOMAIN);}

    public AppException domainException(String detail) {
        return new AppException(this, detail, ErrorType.DOMAIN);
    }
}
