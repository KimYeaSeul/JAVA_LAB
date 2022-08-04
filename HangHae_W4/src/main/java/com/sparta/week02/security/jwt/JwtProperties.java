package com.sparta.week02.security.jwt;

public interface JwtProperties {
    String SECRET="lalallaeijfkdnvkarjhtoifjgij49035uoiwjrglfekmvdz;fj9034qitq0irgjefcnmxcmvxnvmn";
    int EXPIRATION_TIME = 60000;
    int REFRESH_TIME = 60000*10;
    String TOKEN_PREFIX="Bearer ";

    String ACCESS_HEADER = "Access-Token";
    String REFRESH_HEADER = " Refresh-Token";

    String AUTHORITIES_KEY = "auth";
}
