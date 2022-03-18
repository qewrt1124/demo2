package com.example.demo.controller;

import com.example.demo.exception.CustomException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExceptionController {

    @GetMapping("exception1")
    public String exception1() throws Exception {
        boolean isError = true;
        if(isError) throw new Exception("exception!");
        return "exception1";
    }
    @GetMapping("exception2")
    public String exception2() {
        boolean isError = true;
        if(isError) throw new CustomException("runtime exception!");
        return "exception2";
    }

}
