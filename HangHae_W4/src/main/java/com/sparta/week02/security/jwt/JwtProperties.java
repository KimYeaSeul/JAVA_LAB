package com.sparta.week02.security.jwt;

public interface JwtProperties {
    String SECRET="lalallaeijfkdnvkarjhtoifjgij49035uoiwjrglfekmvdz;fj9034qitq0irgjefcnmxcmvxnvmn";
    int EXPIRATION_TIME = 60000;
    int REFRESH_TIME = 60000*10;
    String TOKEN_PREFIX="Bearer ";
    String HEADER_STRING = "AUTHORIZATION";
    String AUTHORITIES_KEY = "auth";
}
