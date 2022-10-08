package com.sparta.week02.dto;

import com.sparta.week02.handler.ErrorResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorDto {
    private int code;
    private String message;
    public ErrorDto(ErrorResponse errorResponse){
        this.code = errorResponse.getCode();
        this.message = errorResponse.getMessage();
    }
}
