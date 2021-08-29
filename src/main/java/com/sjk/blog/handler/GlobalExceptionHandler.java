package com.sjk.blog.handler;

import com.sjk.blog.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class) //IllegalArgumentException 이 발생하면 ExceptionHandler가 작동해서 아래 함수를 실행시킨다.
    public ResponseDto<String> handleArgumentException(Exception e){

        return new ResponseDto<String>(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
    }
}
