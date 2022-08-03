package com.sparta.week02.handler;

import com.sparta.week02.dto.ErrorDto;
import com.sparta.week02.dto.ResponseDto;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseDto<ErrorDto> handleCustomException(CustomException ex){
        ErrorDto response = new ErrorDto(ex.getErrorResponse());
        return new ResponseDto<>("ERROR", response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseDto<ErrorDto> handleException(Exception ex){
        ErrorDto response = new ErrorDto(ErrorResponse.INTER_SERVER_ERROR);
        return new ResponseDto<>("ERROR", response);
    }
}
