package com.example.demo.controller;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HtmlController {
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


}
