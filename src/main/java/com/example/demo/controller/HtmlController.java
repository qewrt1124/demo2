package com.example.demo.controller;

import com.example.demo.model.NightPharmacy;
import com.example.demo.repository.NightPharmacyRepository;
import com.example.demo.vo.Any;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Random;

@Controller
public class HtmlController {

  // 공통 : 사용자의 요청 파라미터를 뷰 템플릿에서 넘겨서 출력
  // 요청 파라미터 : 1-name, 2-age
  // 1. Model 사용

  @Autowired
  NightPharmacyRepository nightPharmacyRepository;

  @GetMapping("/html/req1")
  public String req1(@RequestParam("name") String name, @RequestParam("age") int age, Model model) {
    model.addAttribute("name", name);
    model.addAttribute("age", age);

    return "html/req1";
  }

  // 2. ModelAttribute 사용
  @GetMapping("/html/req2")
  public String req2(@ModelAttribute("any") Any any) {

    return "html/req2";
  }

  @GetMapping("/")
  public String home(Model model) {
    model.addAttribute("number", new Random().nextInt(10));

    return "html/string";
  }

  @GetMapping("html/void") // 퀴즈 이런 곳에 사용
  public void htmlVoid() {
  }

  @GetMapping("html/model_and_view")
  public ModelAndView htmlModel() {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("html/model_and_view");

    return mav;
  }

  @GetMapping("/html/night/page")
  public String jdbcDemo2(
          @PathVariable int page,
          Model model) {
    Sort sort = Sort.by(Sort.Direction.DESC, "id");
    Pageable p = PageRequest.of(-1, 10, sort);
    Page<NightPharmacy> result = nightPharmacyRepository.findAll(p);
    List<NightPharmacy> nightList = result.getContent();

    model.addAttribute("nightList", nightList);
    return "nightList";
  }

}
