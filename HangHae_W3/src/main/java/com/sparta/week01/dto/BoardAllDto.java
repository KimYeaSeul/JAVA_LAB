package com.sparta.week01.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BoardAllDto {
    private String title;
    private String content;
    private String author;
    private Timestamp createAt;
    private Timestamp modifiedAt;

}