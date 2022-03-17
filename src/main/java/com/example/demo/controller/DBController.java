package com.example.demo.controller;

import com.example.demo.dao.HolidayParkingDAO;
import com.example.demo.dao.SunbyulDAO;
import com.example.demo.mapper.PollMapper;
import com.example.demo.mapper.SunbyulMapper;
import com.example.demo.model.Any;
import com.example.demo.model.Demo;
import com.example.demo.model.NightPharmacy;
import com.example.demo.repository.AnyRepository;
import com.example.demo.repository.DemoRepository;
import com.example.demo.repository.NightPharmacyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class DBController {

  @Autowired
  private JdbcTemplate jt;

  @Autowired
  private HolidayParkingDAO hDao;

  @Autowired
  private PollMapper pollMapper;
  
  @Autowired
  private SunbyulDAO sDao;

  @Autowired
  DemoRepository demoRepository;

  @Autowired
  private AnyRepository anyRepository;

  @Autowired
  private NightPharmacyRepository nightPharmacyRepository;

  @Autowired
  private SunbyulMapper sunbyulMapper;
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
    @RequestParam(value = "page", defaultValue = "1") int page) {

    int startRow = page * 10 - 10;

    return hDao.select(startRow);
    // snake_case = kamel_case
  }

  @GetMapping("/jdbc/sunbyul")
  public List<Map<String, Object>> sunbyul(
    @RequestParam(value = "page", defaultValue = "1") int page) {

    int startRow = page * 10 - 10;  
    
    return sDao.Select(startRow);
    }
  
  @GetMapping("/mybatis/poll")
  public String mybatisPoll(
	 @RequestParam Map<String, Object> map) {
	 pollMapper.insert(map);
	  
	 return "ok";
  }
  
  @GetMapping("/mybatis/sunbyul")
  public List<Map<String, Object>> mybatisSunbyul() {
    
    return sunbyulMapper.select();
  }

  @GetMapping("/jpa/demo")
  public List<Demo> jpaDemo() {
    return demoRepository.findAll();
  }

  @GetMapping("/jpa/any")
  public List<Any> jpaAny() {

    return anyRepository.findAll();
  }

  @GetMapping("/jpa/night")
  public List<NightPharmacy> jpaPhamacy() {
    Pageable p = PageRequest.of(1, 5);
    List<NightPharmacy> list = nightPharmacyRepository.findByRoadAddressContainingOrJibunAddressContainingOrderByIdDesc("대전", "대전", p);

    return list;
  }

  @GetMapping("/jpa/night/{page}")
  public List<NightPharmacy> jpaPhamacy2(@PathVariable("page") int page) {

    // Ascending 오름차순
    Sort sort = Sort.by("name");

    // Descending 내림차순
    sort = Sort.by(Sort.Direction.DESC, "id");

    // 시작번호는 0 부터
    Pageable p = PageRequest.of(page-1, 10, sort);

    Page<NightPharmacy> result = nightPharmacyRepository.findAll(p);

    List<NightPharmacy> nightPharmacyList = result.getContent();

    return nightPharmacyList;
  }

  @GetMapping("jpa/demo/{page}")
  public List<Demo> jpaDemo2(@PathVariable("page") int page) {

    Sort sort = Sort.by(Sort.Direction.DESC, "seq");

    Pageable p = PageRequest.of(page-1, 3, sort);

    Page<Demo> result = demoRepository.findAll(p);

    List<Demo> demoList = result.getContent();

    return demoList;
  }
}

//@Data
//class Demo {
//  String user;
//  int seq;
//}