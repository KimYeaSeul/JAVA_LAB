package com.sparta.week02.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardResponseDto {
    private String title;
    private String content;
    private UserResponseDto user;
    private LocalDateTime createAt;
    private LocalDateTime modifiedAt;
    private CommentRequestDto comment;
    // 댓글은 어떻게 가지고 올까요
}
