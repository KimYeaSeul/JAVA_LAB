package com.sparta.week02.security;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MyFilter1 implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        if(req.getMethod().equals("POST")){
            String headerAuth = req.getHeader("Authorization");
            System.out.println("headerAuth " + headerAuth);
            if(headerAuth.equals("COS")){
                chain.doFilter(req, res);
            }else{
                System.out.println("인증 안됨");
                PrintWriter outPrint = res.getWriter();
                outPrint.println("Not Authorization");
            }
        }
        System.out.println("필터1");
    }
}
