package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HtmlController {
  @GetMapping("/")  
  public String home() {  
    return "html/string";
  }
}
