package com.sparta.week02.controller;

import com.sparta.week02.dto.ResponseDto;
import com.sparta.week02.dto.SignupRequestDto;
import com.sparta.week02.dto.SignupResponseDto;
import com.sparta.week02.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserApiController {

    private final UserService userService;
    // 회원 로그인 페이지
//    @PostMapping("/user/login")
//    public String login(@RequestBody LoginDto loginDto) {
//        System.out.println("password " + loginDto.getPassword()+ " , username "+ loginDto.getUsername());
//        return userService.login(loginDto);
//    }
    // JSON으로 보낼거니까 @RequestBody
    @PostMapping("/user/signup")
    public ResponseDto<SignupResponseDto> registerUser(@RequestBody SignupRequestDto requestDto){
//        System.out.println("RequestBody requestDto : " + requestDto);
        //requestDto : SignupRequestDto(username=test, password=1234, email=test@gmail.com, admin=false, adminToken=)
        SignupResponseDto responseUser = userService.registerUser(requestDto);
        return new ResponseDto<>("회원가입 성공", responseUser);
    }

    @GetMapping("/parse")
    public String parses(){
        return "권한 인증 됨";
    }
}