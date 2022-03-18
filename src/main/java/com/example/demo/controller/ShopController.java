package com.example.demo.controller;

import com.example.demo.model.Order;
import com.example.demo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ShopController {

    @Autowired
    OrderRepository orderRepository;

    @GetMapping("/order/json")
    @ResponseBody
    public List list1() {
        List<Order> list = new ArrayList();

        list = orderRepository.findAll();
        List shopList = new ArrayList();

        for(int i = 0; i < list.size(); i++) {
            Order order = list.get(i);
            shopList.add(order);
        }

        return shopList;
    }

    @GetMapping("/order/{page}")
    public ModelAndView list2(
            @PathVariable("page") int page
    ) {
        ModelAndView mv = new ModelAndView();
//        List<Order> list = new ArrayList();

        Sort sort = Sort.by(Sort.Direction.ASC, "ordDate");

        Pageable p = PageRequest.of(page-1, 5, sort);

        Page<Order> list = orderRepository.findAll(p);
//        list = orderRepository.findAll(sort);
        List shopList = new ArrayList();

        for(int i = 0; i < list.getSize(); i++) {
            Order order = list.getContent().get(i);
            shopList.add(order);
        }

        int countPage = list.getSize() % 5;
        if(countPage != 0) {
            countPage = list.getSize() / 5 + 1;
        } else {
            countPage = list.getSize() / 5;
        }

        mv.addObject("countPage", countPage);
        mv.addObject("shopList", shopList);
        mv.setViewName("shopList");

        return mv;
    }

}
