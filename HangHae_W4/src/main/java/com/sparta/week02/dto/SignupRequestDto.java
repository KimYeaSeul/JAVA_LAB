package com.sparta.week02.dto;

import lombok.Data;

@Data
public class SignupRequestDto {
    private String username;
    private String password;
    private String passwordCheck;
    private String email;
    private boolean admin = false;
    private String adminToken = "";
}
