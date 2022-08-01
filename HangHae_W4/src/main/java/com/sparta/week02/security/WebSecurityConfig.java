package com.sparta.week02.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
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
        http.csrf().ignoringAntMatchers("/user/**");
        http.authorizeHttpRequests((authz) -> authz
                        .antMatchers("/image/**")
                        .permitAll()
                        .antMatchers("/css/**")
                        .permitAll()
                        .antMatchers("/user/**")
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
