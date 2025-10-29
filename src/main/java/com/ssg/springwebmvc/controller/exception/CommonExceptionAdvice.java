package com.ssg.springwebmvc.controller.exception;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;


@Log4j2
@ControllerAdvice
public class CommonExceptionAdvice {

    @ResponseBody
    //내가 만든 문자열 그대로 브라우저에 전송하겠다는 의미의 ResponseBody -> JSON 다룰 때 사용
    @ExceptionHandler(value = NumberFormatException.class)
    public String exceptNumber(NumberFormatException numberFormatException) {
        log.info("numberFormatException: " + numberFormatException);
        return "Number Format Exception!";
    }

    @ExceptionHandler(value = NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String notFound(NoHandlerFoundException noHandlerFoundException) {
        return "custom404";
    }

}
