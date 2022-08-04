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
   @Value(JwtProperties.JWT_SECRET)
    private String secretKey;

    // 토큰 생성
    private String doGenerateToken(String username, int expireTime){
        Claims claims = Jwts.claims();
        claims.put("username", username);
        Key key = Keys.hmacShaKeyFor(JwtProperties.JWT_SECRET.getBytes(StandardCharsets.UTF_8));
        Date now = new Date();
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date())
                .setExpiration(new Date(now.getTime()+ expireTime))
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

    private Claims parseClaims(String token){
        try{
            return Jwts.parserBuilder()
                    .setSigningKey(getSigningKey(secretKey))
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
        }catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException | IllegalArgumentException e){
            // 별개 예외처리 필요
//            throw new CustomException(ErrorResponse.INVALID_TOKEN);
            e.printStackTrace();

        }
        return null;
    }

    // 이름 구하는 함수
    public String getName(String token){
        Claims parse = parseClaims(token);
        if(parse == null) return null;
        else return parse.get("username", String.class);
    }

    // 만료 여부 확인
    private Boolean isTokenExpired(String token){
        Date expiration = parseClaims(token).getExpiration();
        return expiration.before(new Date());
    }

}
