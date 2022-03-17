package com.example.demo;

import com.example.demo.model.Emp;
import com.example.demo.repository.EmpRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class EmpRepositoryTests {

    @Autowired
    EmpRepository empRepository;

    @Test
    void 부서조회() {
        List<Emp> opt = empRepository.findAll();

        List<Emp> emp = new ArrayList<>();
        for(int i = 0; i < opt.size(); i++) {
            emp.add(opt.get(i));
            String deptName = emp.get(i).getDept().getDname();
            String deptLoc = emp.get(i).getDept().getLoc();

        }
    }
}
