package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Json2Controller {
  @GetMapping("json2/string")
  @ResponseBody
  public String json() {

    return "json2/string";
  }

  @GetMapping("json2/map")
  @ResponseBody
  public Map<String, Object> jsonMap(Map<String, Object> map) {
    Map<String, Object> map2 = new HashMap<String, Object>();
    map2.put("key1", "value");
    map2.put("key2", 2324);
    map2.put("key3", true);

    return map2;
  }

  @GetMapping("json2/list")
  @ResponseBody
  public List<String> jsonList() {
    List<String> list = new ArrayList<>();
    list.add("1");
    list.add("2");
    list.add("3");
    
    return list;
  }
}
