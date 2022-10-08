package com.sparta.week02.security.jwt;

public interface JwtProperties {
    String JWT_SECRET="lalallaeijfkdnvkarjhtoifjgij49035uoiwjrglfekmvdz;fj9034qitq0irgjefcnmxcmvxnvmn";
    String ACCESS_PREFIX="Bearer ";
    String REFRESH_PREFIX="Refresh ";

    String ACCESS_HEADER = "Access-Token";
    String REFRESH_HEADER = "Refresh-Token";
    int SEC = 1000;
    int MINUTE = 60 * SEC;
    int HOUR = 60 * MINUTE;
    int DAY = 24 * HOUR;

    // JWT 토큰의 유효기간: 1일 (단위: seconds)
    int JWT_TOKEN_VALID_SEC = 1 * DAY;

    // JWT 토큰의 유효기간: 1일 (단위: milliseconds)
    int JWT_TOKEN_VALID_MILLI_SEC = JWT_TOKEN_VALID_SEC * 1000;
    int EXPIRATION_TIME = JWT_TOKEN_VALID_SEC;
    int REFRESH_TIME = JWT_TOKEN_VALID_SEC;

    String CLAIM_EXPIRED_DATE = "EXPIRED_DATE";
    String CLAIM_USER_NAME = "USER_NAME";
    String AUTHORITIES_KEY = "auth";
}
