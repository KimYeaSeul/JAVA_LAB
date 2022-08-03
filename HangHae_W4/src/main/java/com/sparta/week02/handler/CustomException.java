package com.sparta.week02.handler;

import lombok.Getter;

@Getter
public class CustomException extends RuntimeException{
    private final ErrorResponse errorResponse;
    public CustomException(ErrorResponse errorResponse){
        this.errorResponse = errorResponse;
    }
}
