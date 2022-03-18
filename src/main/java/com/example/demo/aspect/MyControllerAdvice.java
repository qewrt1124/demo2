package com.example.demo.aspect;

import com.example.demo.controller.ExceptionController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

@Slf4j
@ControllerAdvice(assignableTypes = { ExceptionController.class })
public class MyControllerAdvice {
    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public String handle(RuntimeException e, WebRequest request) {
        String message = e.getMessage();
        log.debug(message);

        return "<h1>" + message + "</h1>";
    }
}