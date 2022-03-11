package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {

  @RequestMapping("/home")
  public String home() {

    return "home"; // 차이점 .jsp(X)  -> thymeleaf 씀
  }

  @RequestMapping("/api")
  @ResponseBody
  public Map api() {    
    Map map = new HashMap<>();
    map.put("id", "abcd");
    map.put("age", 1234);

    // 멀티쓰레드 사용 -> 출력하는 동안 웹서비스 동작에 영향을 주지 않음
    // 설정을 통해서 로그를 파일로 저장 가능
    // System.out.println("trace!"); 출력할 때 까지는 웹이 동작하지 않음
    // log.trace("trace!");
    // log.debug("debug!");
    // log.info("info!");
    // log.warn("warn!");
    // log.error("error!");

    return map;
  }
}
