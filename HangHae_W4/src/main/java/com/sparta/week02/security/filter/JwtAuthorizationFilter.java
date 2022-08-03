package com.sparta.week02.security.filter;

import com.sparta.week02.model.Users;
import com.sparta.week02.repository.UserRepository;
import com.sparta.week02.security.UserDetailsImpl;
import com.sparta.week02.security.jwt.JwtProperties;
import com.sparta.week02.security.jwt.TokenProvider;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;


public class JwtAuthorizationFilter extends BasicAuthenticationFilter {

    private final UserRepository userRepository;

    private final TokenProvider tokenProvider;
    public JwtAuthorizationFilter(AuthenticationManager authenticationManager, UserRepository userRepository, TokenProvider tokenProvider) {
        super(authenticationManager);
        this.userRepository = userRepository;
        this.tokenProvider = tokenProvider;
    }

    // 인증이나 권한이 필요한 주소요청이 있을 때 해당 필터를 타게 됨.
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {

        System.out.println("인증이나 권한이 필요한 주소 요청이 됨.");
        // 얘 안지워줘서 에러남
//		super.doFilterInternal(request, response, chain);

        String jwtHeader = request.getHeader(JwtProperties.HEADER_STRING);
        System.out.println("jwtHeader : " + jwtHeader);
        String refreshJwt = request.getHeader("refreshtoken");

        System.out.println("refreshtoken : " + refreshJwt);

        // header가 있는지 확인
        if(jwtHeader == null || !jwtHeader.startsWith("Bearer")
        || refreshJwt == null || !refreshJwt.startsWith("Refresh")) {
            System.out.println("틀렸다능!");
            chain.doFilter(request, response);
            return;
        }


        // JWT Token을 검증을 해서 정상적인 사용자인지 확인
        String jwtToken = request.getHeader(JwtProperties.HEADER_STRING).replace(JwtProperties.TOKEN_PREFIX, "");
        String username = tokenProvider.getName(jwtToken);
//                JWT.require(Algorithm.HMAC512(JwtProperties.SECRET)).build().verify(jwtToken).getClaim("username").asString();

         System.out.println("검증 완료 후 이름 추출 " + username);
        if(username == null) {
            System.out.println("틀렸다능!");
            chain.doFilter(request, response);
            return;
        }
//        // 서명이 정상적으로 되었다.
            Optional<Users> userEntity = userRepository.findByUsername(username);
            if(userEntity.isPresent()){
                Users user = userEntity.get();
                UserDetailsImpl principalDetails = new UserDetailsImpl(user);

                // jwt 토큰 서명을 통해서 서명이 정상이면 authentication 객체를 (강제로) 만들어 준다.
                Authentication authentication =
                        new UsernamePasswordAuthenticationToken(principalDetails, null, principalDetails.getAuthorities()); // password = null
                System.out.println("authentication = "+authentication);
                System.out.println("됐냐능?");
                // 강제로 시큐리티 세션에 접근하여 authentication 객체를 저장. -> 로그인 완료
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
            chain.doFilter(request, response);
        }
    }
