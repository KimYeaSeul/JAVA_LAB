package com.sparta.week02.security;

import com.sparta.week02.repository.RefreshTokenRepository;
import com.sparta.week02.repository.UserRepository;
import com.sparta.week02.security.filter.JwtAuthorizationFilter;
import com.sparta.week02.security.jwt.JwtAuthehnticationFilter;
import com.sparta.week02.security.jwt.TokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebSecurityConfig{
    private final CorsFilter corsFilter;
    private final AuthenticationConfiguration authenticationManager;
    private final UserRepository userRepository;
    private final RefreshTokenRepository refreshTokenRepository;
    private static final String[] PERMIT_URL_ARRAY = {
            /* swagger v2 */
            "/v2/api-docs",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui.html",
            "/webjars/**",
            /* swagger v3 */
            "/v3/api-docs/**",
            "/swagger-ui/**",
            "/swagger"
    };
//    private final UserDetailsServiceImpl userDetailsService;
//    private final JwtAuthehnticationFilter jwtAuthehnticationFilter;
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
        public AuthenticationManager authenticationManager() throws Exception {
            return authenticationManager.getAuthenticationManager();
        }


//        private final AuthenticationManager auth;
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//        http.addFilterBefore(new MyFilter1(), SecurityContextHolderFilter.class);
        http.authorizeHttpRequests((authz) -> authz
                        .antMatchers("/image/**")
                        .permitAll()
                        .antMatchers("/css/**")
                        .permitAll()
                        .antMatchers("/user/**")
                        .permitAll()
                        .antMatchers("/boards/**")
                        .permitAll()
                        .antMatchers(PERMIT_URL_ARRAY)
                        .permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin().disable()
                .addFilter(corsFilter)
//                .authenticationManager(authenticationManager)
                .addFilterBefore( new JwtAuthehnticationFilter(authenticationManager(), TokenProvider(), refreshTokenRepository), UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore( new JwtAuthorizationFilter(authenticationManager(), userRepository, TokenProvider()), UsernamePasswordAuthenticationFilter.class);
//                .addFilter(new JwtAuthehnticationFilter(authenticationManager()));
//
        return http.build();
    }
    @Bean
    public TokenProvider TokenProvider() {
        return new TokenProvider();
    }

}
