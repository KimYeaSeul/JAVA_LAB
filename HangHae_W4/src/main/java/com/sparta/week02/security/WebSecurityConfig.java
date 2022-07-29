package com.sparta.week02.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    @Bean
    public SecurityFilterChain filterChian(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((authz) -> authz
                        .antMatchers("/image/**")
                        .permitAll()
                        .antMatchers("/css/**")
                        .permitAll()
                        .antMatchers("/user/signup")
                        .permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin()
                .loginPage("/user/login")
                .defaultSuccessUrl("/")
                .failureUrl("/user/login?error")
                .permitAll()
                .and()
                .logout()
                .permitAll();

        return http.build();
    }
}
