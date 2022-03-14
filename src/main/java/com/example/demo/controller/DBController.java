package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import com.example.demo.dao.HolidayParkingDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;

@RestController
public class DBController {

  @Autowired
  private JdbcTemplate jt;

  @Autowired
  private HolidayParkingDAO hDao;
  // 1. 클래스 영역에 명령문(코드) 작성 X
  // List list = null;
  // list.add(1);

  @GetMapping("/jdbc/demo")
  public List<Map<String, Object>> jdbcDemo() {

    // const a = 10;
    // let b = 10;
    // int i = 10;
    // String s = "aa";

    // 2. 지역변수는 반드시 초기화 수행 후 활용
    // List<Object> list = null;
    // list.add(1);
    // list.add("aaa");

    return jt.queryForList("select * from demo");
  }

  @GetMapping("/jdbc/demo2")
  public Demo jdbcDemo2() {

    return jt.queryForObject("select * from demo limit 0, 1", Demo.class);
  }

  @GetMapping("/jdbc/exam4")
  public List<Map<String, Object>> exam4() {

    return jt.queryForList("SELECT * FROM holiday_parking WHERE gu='금천구'");
  }
  
  @GetMapping("/jdbc/parking")
  public List<Map<String, Object>> parking(
    @RequestParam(value = "page", defaultValue = "0") int page) {

    return hDao.select(page);
    // snake_case = kamel_case
  }
}

@Data
class Demo {
  String user;
  int seq;
}