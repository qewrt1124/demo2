package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestController {

  @GetMapping("req/param1")
  // RequestParam의 기본은 필수 값
  public String param1(
      @RequestParam("key1") String key1,
      @RequestParam("key2") String key2,
      @RequestParam(value = "key3", defaultValue = "Z") String key3) {

    return key1 + ", " + key2 + ", " + key3;
  }
}
