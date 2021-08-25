package com.sjk.blog.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class) //IllegalArgumentException 이 발생하면 ExceptionHandler가 작동해서 아래 함수를 실행시킨다.
    public String handleArgumentException(Exception e){
        return "<h1>" +e.getMessage() + "</h1>";
    }
}
