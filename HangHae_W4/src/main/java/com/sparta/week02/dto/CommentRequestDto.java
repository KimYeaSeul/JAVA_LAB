package com.sparta.week02.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class CommentRequestDto {
    private String title;
    private String content;
    private LocalDateTime createAt;
    private LocalDateTime modifiedAt;
}
