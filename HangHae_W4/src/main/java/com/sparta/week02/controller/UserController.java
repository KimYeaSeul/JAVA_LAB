package com.sparta.week02.controller;

import com.sparta.week02.dto.SignupRequestDto;
import com.sparta.week02.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService;
    // 회원 로그인 페이지
    @GetMapping("/user/login")
    public String login() {
        return "login";
    }

    // 회원 가입 페이지
    @GetMapping("/user/signup")
    public String signup() {
        return "signup";
    }

    @PostMapping("/user/signup")
    public String registerUser(@RequestBody SignupRequestDto requestDto){
        System.out.println("RequestBody requestDto : " + requestDto);
        //requestDto : SignupRequestDto(username=test, password=1234, email=test@gmail.com, admin=false, adminToken=)
        userService.registerUser(requestDto);
        return "redirect:/user/login";
    }
}