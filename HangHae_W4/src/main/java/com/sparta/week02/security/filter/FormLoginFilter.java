package com.sparta.week02.security.filter;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormLoginFilter extends UsernamePasswordAuthenticationFilter {
    final private ObjectMapper objectMapper;
    private final AuthenticationManager authenticationManager;
    public FormLoginFilter(AuthenticationManager authenticationManager) {
//        super.setAuthenticationManager(authenticationManager);
        this.authenticationManager = authenticationManager;
        objectMapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        UsernamePasswordAuthenticationToken authRequest;
        try {
            System.out.println("여기는 formlogin filter입니다.");
            JsonNode requestBody = objectMapper.readTree(request.getInputStream());
            String username = requestBody.get("username").asText();
            String password = requestBody.get("password").asText();
            System.out.println("username = "+ username + " password " + password);
            authRequest = new UsernamePasswordAuthenticationToken(username, password);
        } catch (Exception e) {
            throw new RuntimeException("username, password 입력이 필요합니다. (JSON)");
        }

        setDetails(request, authRequest);
        return this.authenticationManager.authenticate(authRequest);
    }
}
