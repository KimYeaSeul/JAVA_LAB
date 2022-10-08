package com.sparta.week02.model;

import com.sparta.week02.dto.UsersDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UsersTest {

    @Test
//    @DisplayName("TestOK")
    void createUser_Normal() {
        int id = 1;
        String username = "test name";
        String password = "1234";
        String email = "adgjl3151@naver.com";
        UserRoleEnum role = UserRoleEnum.USER;


        UsersDto userdto = new UsersDto(username, password, email, role);

        // 생성자 함수를 테스트 하겠다.!
        Users user = new Users(userdto, id);

        assertEquals(username, user.getUsername());
        assertEquals(password, user.getPassword());
        assertEquals(email, user.getEmail());
        assertEquals(role, user.getRole());
    }
}