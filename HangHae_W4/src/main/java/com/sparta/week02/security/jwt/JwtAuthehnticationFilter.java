package com.sparta.week02.security.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.week02.controller.RefreshToken;
import com.sparta.week02.model.Users;
import com.sparta.week02.repository.RefreshTokenRepository;
import com.sparta.week02.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@RequiredArgsConstructor
public class JwtAuthehnticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;
    private final TokenProvider tokenProvider;

    private final RefreshTokenRepository refreshTokenRepository;
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {
        System.out.println("JwtAuthehnticationFIlter : 로그인 시도중");
        try {
            ObjectMapper om = new ObjectMapper();
            Users user = om.readValue(request.getInputStream(), Users.class);
            System.out.println("username = " + user.getUsername() + " password = "+ user.getPassword());
            // 1. Login ID/PW 를 기반으로 AuthenticationToken 생성
            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
            System.out.println("authenticationToken "+ authenticationToken);
            // 2. 실제로 검증 (사용자 비밀번호 체크) 이 이루어지는 부분
            //    authenticate 메서드가 실행이 될 때 CustomUserDetailsService 에서 만들었던 loadUserByUsername 메서드가 실행됨
            System.out.println(authenticationManager.authenticate(authenticationToken));
            return authenticationManager.authenticate(authenticationToken);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        out.println("Login Fail : Check your Username Or Password");

//        super.unsuccessfulAuthentication(request, response, failed);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
                                            Authentication authentication) throws IOException, ServletException {
        System.out.println("successfulAuthentication : 로그인 완료 후 실행됨.");
        System.out.println("authentication "+ authentication);
        UserDetailsImpl userdetails = (UserDetailsImpl) authentication.getPrincipal();
        System.out.println("userdetails "+ userdetails.toString());
        // 3. 인증 정보를 기반으로 JWT 토큰 생성
        String access_token = tokenProvider.generateAccessToken(userdetails.getUser().getUsername());
        String refresh_token = tokenProvider.generateRefreshToken(userdetails.getUser().getUsername());
        RefreshToken rttr = refreshTokenRepository.findByUser(userdetails.getUser());
        System.out.println(" repository refreshtoken " + rttr.getRefreshToken());
        System.out.println("refreshtoken " + refresh_token);

        if(rttr == null){
            RefreshToken rt = RefreshToken.builder()
                    .user(userdetails.getUser())
                    .token(refresh_token)
                    .build();
            refreshTokenRepository.save(rt);
        }else{
            rttr.setRefreshToken(refresh_token);
            refreshTokenRepository.save(rttr);
        }

        PrintWriter out = response.getWriter();
        out.println("Login Success : Welcome "+userdetails.getUsername());
        response.addHeader("Authorization", "Bearer " + access_token);
        response.addHeader("RefreshToken", "Refresh " + refresh_token);
    }

}
