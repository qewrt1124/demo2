package com.example.demo.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class MyBatisLogAspect {

    @AfterReturning(value = "execution (* com.example.demo.controller..DB*.mybatis*(..))",
            returning = "data")
    public void onAfterReturningHandler(JoinPoint joinPoint, Object data) {
        if (data != null) {
            log.debug(data.toString());
        }
        log.debug("@AfterReturning run");
    }

}
