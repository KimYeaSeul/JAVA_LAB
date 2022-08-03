package com.sparta.week02.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebSecurityConfig {

    @Bean
    public BCryptPasswordEncoder encodePassword(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer(){
        return (web) -> web.ignoring()
                .antMatchers("/h2-console/**");
    }
    @Bean
    public SecurityFilterChain filterChian(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.csrf()
                .ignoringAntMatchers("/user/**")
                .ignoringAntMatchers("api/products/**");
//        .ignoringAntMatchers("api/products/**");
        http.authorizeHttpRequests((authz) -> authz
                        .antMatchers("/image/**")
                        .permitAll()
                        .antMatchers("/css/**")
                        .permitAll()
                        .antMatchers("/user/**")
                        .permitAll()
                        .antMatchers("/api/boards/**")
                        .permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin()
                .loginPage("/user/login") // 로그인 View ( GET /user/login)
                .loginProcessingUrl("/user/login") // 로그인 처리( POST /user/login)
                .defaultSuccessUrl("/") // 로그인 처리 후 성공시 URL
                .failureUrl("/user/login?error") // 로그인 처리 후 실패시 URL
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/user/logout")
                .permitAll()
                .and()
                .exceptionHandling()
                .accessDeniedPage("/forbidden.html");

        return http.build();
    }
}
