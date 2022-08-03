package com.sparta.week02.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SignupResponseDto {
    int id;
    String username;
    String email;
}
