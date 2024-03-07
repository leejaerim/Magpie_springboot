package com.jed.mapie.common.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    COMMON_INVALID_PARAMETER("요청한 값이 올바르지 않습니다."),
    COMMON_ENTITY_NOT_FOUND("엔티티를 찾을 수 없습니다."),
    COMMON_UNAUTHORIZED("인증되지 않은 유저 입니다."),
    ALREADY_LOGOUT("이미 로그아웃한 유저 입니다.");
    private final String description;

}
