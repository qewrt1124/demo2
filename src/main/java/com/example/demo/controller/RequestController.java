package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import com.example.demo.vo.Data;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestController {

  @GetMapping("/req/data")
  public Map<String, Object> data(
    @RequestParam(value = "area", required = false) String area,
    @RequestParam(value = "score", required = false) Integer score,
    @ModelAttribute("data") Data data) {
    
    Map<String, Object> map = new HashMap<>();
    if(area != null) {
      map.put("area", area);
    }
    if(score != null) {
      map.put("score", score);
    }

    return map;
  }

  @GetMapping("/req/path/{a}/{b}")
  public String path(
    @PathVariable("a") String a,
    @PathVariable("b") String b
    ) {
      
      return a + " / " + b;
    }

  @GetMapping("/req/param1")
  // RequestParam의 기본은 필수 값
  public String param1(
      @RequestParam("key1") String key1,
      @RequestParam("key2") String key2,
      @RequestParam(value = "key3", defaultValue = "Z") String key3) {

    return key1 + ", " + key2 + ", " + key3;
  }
}
