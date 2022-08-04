package com.sparta.week02.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BoardDto {
    int id;
    String title;
    String content;
    String author;
}
