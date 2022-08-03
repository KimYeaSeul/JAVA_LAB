package com.sparta.week02.security.jwt;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Component
public class TokenProvider {
    private static final int SEC = 1;
    private static final int MINUTE = 60 * SEC;
    private static final int HOUR = 60 * MINUTE;
    private static final int DAY = 24 * HOUR;

    // JWT 토큰의 유효기간: 3일 (단위: seconds)
    private static final int JWT_TOKEN_VALID_SEC = 3 * DAY;
    // JWT 토큰의 유효기간: 3일 (단위: milliseconds)
    private static final int JWT_TOKEN_VALID_MILLI_SEC = JWT_TOKEN_VALID_SEC * 1000;

    public static final String CLAIM_EXPIRED_DATE = "EXPIRED_DATE";
    public static final String CLAIM_USER_NAME = "USER_NAME";
    public static final String JWT_SECRET = "jwt_secret_!@#$%";

    @Value(JwtProperties.SECRET)
    private String secretKey;

    // 넘어온 키?
//    public TokenPRovider(String secretKey){
//        this.secretKey = secretKey;
//    }
    // 토큰 생성
    private String doGenerateToken(String username, int expireTime){
        Claims claims = Jwts.claims();
        claims.put("username", username);
        Key key = Keys.hmacShaKeyFor(JwtProperties.SECRET.getBytes(StandardCharsets.UTF_8));
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expireTime))
                .signWith(key)
                .compact();
    }

//     access token 생성 함수
    public String generateAccessToken(String username){
        return doGenerateToken(username, JwtProperties.EXPIRATION_TIME);
    }
    // refresh token 생성 함수
    public String generateRefreshToken(String username){
        return doGenerateToken(username, JwtProperties.REFRESH_TIME);
    }

    // 서명된 키를 구하는 함수
    private SecretKey getSigningKey(String secretKey){
        byte[] keyBytes = secretKey.getBytes(StandardCharsets.UTF_8);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    // 토큰 해석
    public Boolean validateToken(String token){
        try {
            Jwts.parserBuilder()
                    .setSigningKey(getSigningKey(secretKey))
                    .build()
                    .parseClaimsJws(token);
            return true;
        }catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException | IllegalArgumentException e){
            e.printStackTrace();
//            throw new CustomException(ErrorResponse.INVALID_TOKEN);
        }
        return false;
    }

//    public Authentication getAuthentication(String accessToken) {
//        // 토큰 복호화
//        Claims claims = parseClaims(accessToken);
//
//        if (claims.get(JwtProperties.AUTHORITIES_KEY) == null) {
//            throw new RuntimeException("권한 정보가 없는 토큰입니다.");
//        }
//
//        // 클레임에서 권한 정보 가져오기
//        Collection<? extends GrantedAuthority> authorities =
//                Arrays.stream(claims.get(JwtProperties.AUTHORITIES_KEY).toString().split(","))
//                        .map(SimpleGrantedAuthority::new)
//                        .collect(Collectors.toList());
//
//        // UserDetails 객체를 만들어서 Authentication 리턴
//        UserDetailsImpl principal = new Users(claims.getSubject(), "", authorities);
//
//        return new UsernamePasswordAuthenticationToken(principal, "", authorities);
//    }

    private Claims parseClaims(String token){
        try{
            return Jwts.parserBuilder()
                    .setSigningKey(getSigningKey(secretKey))
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
        }catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException | IllegalArgumentException e){
            e.printStackTrace();

        }
        return null;
    }
    // 이름 구하는 함수
    public String getName(String token){
//        if(isTokenExpired(token)){
//            System.out.println("만료된 토큰이라능");
//            throw new CustomException(ErrorResponse.INVALID_TOKEN);
//        }
        Claims parse = parseClaims(token);
        if(parse == null) return null;
        else return parse.get("username", String.class);
    }
//    // access 유효시간 알림
//    public int getValidationAccessTokenTime(){
//        return JwtProperties.EXPIRATION_TIME;
//    }
    // 토큰이 만료됬는지 확인하는 함수
    private Boolean isTokenExpired(String token){
        Date expiration = parseClaims(token).getExpiration();
        return expiration.before(new Date());
    }

}
