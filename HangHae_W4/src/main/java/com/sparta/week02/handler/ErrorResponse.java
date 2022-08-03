package com.sparta.week02.handler;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorResponse {

    NOT_FOUND(404,"PAGE NOT FOUND"),
    INTER_SERVER_ERROR(500,"INTER SERVER ERROR"),
    INVALID_NICKNAME(400,"닉네임은 영어와 숫자를 포함하여 4자이상 12자 이하로 해주세요."),
    DUPLICATION_NICKNAME(400,"중복된 사용자 ID가 존재합니다."),
    DUPLICATION_EMAIL(400,"중복된 EMAIL이 존재합니다."),
    NOT_MATCHING_PASSWORD(400,"비밀번호와 비밀번호 확인이 일치하지 않습니다."),
    INVALID_PASSWORD(400,"비밀번호는 소문자와 숫자를 포함하여 4자이상 32자 이하로 해주세요."),
    NOT_MATCHING_ADMIN_TOKEN(400,"관리자 암호가 틀려 등록이 불가합니다."),
    BLANK(400,"빈칸을 입력해주세요."),
    INVALID_TOKEN(400,"유효하지 않은 토큰입니다"),
    NOT_FOUND_TOKEN(400,"토큰이 없거나 유효하지 않습니다.(로그인하쇼)"),
    NOT_FOUND_USER(400,"유저 아이디를 찾을 수 없습니다."),
    NOT_FOUND_BOARD(400,"해당 게시글을 찾을 수 없습니다."),
    NOT_FOUND_COMMENT(400,"해당 댓글을 찾을 수 없습니다."),
    NOT_MATCH_USER(400,"작성자만 수정할 수 있습니다."),

    ;

    private final int code;
    private final String message;
}
