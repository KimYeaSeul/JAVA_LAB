package com.sparta.week02.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LoginDto {
    @NotNull
    private String username;
    @NotNull
    private String password;
}
