package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class SessionController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/join")
    public String join() {
        return "join";
    }

    @PostMapping("/join")
    public String joinPost(@ModelAttribute User user) {

        userRepository.save(user);

        System.out.println(user);

        Map<String, Object> map = new HashMap<>();

        return "redirect:/login";
    }

    @PostMapping("/login")
    @ResponseBody
    public Map<String, Object> loginPost(User user, HttpSession session) {
        session.setAttribute("user", user);
        System.out.println(user.getUserId());
        System.out.println(user.getUserPw());
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        Map<String, Object> map = new HashMap<>();

        if(user.getUserId().equals("a")) {
            map.put("result", "로그인 성공");
            map.put("code", 200);
        } else {
            map.put("result", "로그인 실패");
            map.put("code", 300);
        }

        return map;
    }

    @GetMapping("/main")
    public String main() {
        return "main";
    }
}
