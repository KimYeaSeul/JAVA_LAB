package com.sparta.week02.dto;

import com.sparta.week02.model.UserRoleEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UsersDto {
    String username ;
    String password ;
    String email;
    UserRoleEnum role;

}
