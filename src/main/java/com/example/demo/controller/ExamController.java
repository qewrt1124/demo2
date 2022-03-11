package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class ExamController {
  @GetMapping("/html/exam")
  public String exam() {

    return "/html/exam";
  }

  @GetMapping("/json/exam")
  @ResponseBody
  public Map exam2() {
    List list = new ArrayList<>();
    Map map1 = new HashMap<>();
    Map map2 = new HashMap<>();
    Map map3 = new HashMap<>();
    
    map1.put("name", "가");
    map1.put("userId", "A");
    map1.put("userPassword", "1");

    map2.put("name", "나");
    map2.put("userId", "B");
    map2.put("userPassword", "2");

    list.add(map1);
    list.add(map2);

    map3.put("count", 2);
    map3.put("list", list);

    return map3;
  }

}
