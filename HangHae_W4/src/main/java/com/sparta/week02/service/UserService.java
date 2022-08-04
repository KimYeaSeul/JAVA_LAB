package com.sparta.week02.service;

import com.sparta.week02.dto.SignupRequestDto;
import com.sparta.week02.dto.SignupResponseDto;
import com.sparta.week02.handler.CustomException;
import com.sparta.week02.handler.ErrorResponse;
import com.sparta.week02.model.UserRoleEnum;
import com.sparta.week02.model.Users;
import com.sparta.week02.repository.UserRepository;
import com.sparta.week02.security.jwt.TokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final PasswordEncoder passwordEncoder;
    private final TokenProvider tokenProvider;
    private static final String ADMIN_TOKEN="diffkdiffkdiffktyddiffkfldiffk";

    public SignupResponseDto registerUser(SignupRequestDto requestDto) {

        String username = "";
        if(requestDto.getUsername().isEmpty()) throw new CustomException(ErrorResponse.BLANK);
        if(checkNickname(requestDto.getUsername())){
            username = requestDto.getUsername();
        }else{
            throw new CustomException(ErrorResponse.INVALID_NICKNAME);
        }
        Optional<Users> nickname = userRepository.findByUsername(username);

        if(nickname.isPresent()){
            throw new CustomException(ErrorResponse.DUPLICATION_NICKNAME);
        }

        String reqEmail = requestDto.getEmail();
        Optional<Users> email = userRepository.findByEmail(reqEmail);
        if(requestDto.getEmail().isEmpty()) throw new CustomException(ErrorResponse.BLANK);
        if(email.isPresent()){
            throw new CustomException(ErrorResponse.DUPLICATION_EMAIL);
        }

        String password = "";
        if(requestDto.getPassword().isEmpty()) throw new CustomException(ErrorResponse.BLANK);
        if(requestDto.getPasswordCheck().isEmpty()) throw new CustomException(ErrorResponse.BLANK);
        if(checkPassword(requestDto.getPassword())){
            password = passwordEncoder.encode(requestDto.getPassword());
        }else{
            throw new CustomException(ErrorResponse.INVALID_PASSWORD);
        }

        if(!requestDto.getPassword().equals(requestDto.getPasswordCheck())){
            throw new CustomException(ErrorResponse.NOT_MATCHING_PASSWORD);
        }

        UserRoleEnum role;
        if(requestDto.isAdmin()){
            if(!requestDto.getAdminToken().equals(ADMIN_TOKEN)){
                throw new CustomException(ErrorResponse.NOT_MATCHING_ADMIN_TOKEN);
            }
            role = UserRoleEnum.ADMIN;
        }else{
            role = UserRoleEnum.USER;
        }

        Users user = new Users(username, password, reqEmail, role);
        userRepository.save(user);
        SignupResponseDto srd = SignupResponseDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .build();

        return srd;
    }

    private boolean checkPassword(String pw){
        Pattern passPattern = Pattern.compile("^(?=.*[a-z])(?=.*\\d).{4,32}$");
        Matcher passMatcher = passPattern.matcher(pw);
        return passMatcher.find();
    }

    private boolean checkNickname(String nickname){
        Pattern passPattern = Pattern.compile("^(?=.*[a-zA-Z])(?=.*\\d).{4,12}$");
        Matcher passMatcher = passPattern.matcher(nickname);
        return passMatcher.find();
    }

//    public String login(LoginDto loginDto){
//        System.out.println("UserService Login ");
//        // 1. Login ID/PW 를 기반으로 AuthenticationToken 생성
//        UsernamePasswordAuthenticationToken authenticationToken =
//                new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword());
//        System.out.println("authenticationToken "+ authenticationToken);
//        // 2. 실제로 검증 (사용자 비밀번호 체크) 이 이루어지는 부분
//        //    authenticate 메서드가 실행이 될 때 CustomUserDetailsService 에서 만들었던 loadUserByUsername 메서드가 실행됨
//        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
//        System.out.println("authentication "+ authentication);
//        UserDetailsImpl userdetails = (UserDetailsImpl) authentication.getPrincipal();
//        System.out.println("userdetails "+ userdetails.toString());
//        // 3. 인증 정보를 기반으로 JWT 토큰 생성
//        String token = tokenProvider.geterateAccessToken(userdetails.getUser().getUsername());
//        System.out.println("login Service : Generate Token : "+ token);
//
//        // 4. RefreshToken 저장
////        RefreshToken refreshToken = RefreshToken.builder()
////                .key(authentication.getName())
////                .value(tokenDto.getRefreshToken())
////                .build();
////
////        refreshTokenRepository.save(refreshToken);
//
//        // 5. 토큰 발급
//        return token;
//    }
}
