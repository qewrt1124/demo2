package com.example.demo;

import com.example.demo.model.Dept;
import com.example.demo.model.Emp;
import com.example.demo.repository.DeptRepository;
import com.example.demo.repository.EmpRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
public class EmpRepositoryTests {

    @Autowired
    EmpRepository empRepository;

    @Autowired
    DeptRepository deptRepository;

    @Test
    void 부서조회() {
        List<Emp> opt = empRepository.findAll();

        for(int i = 0; i < opt.size(); i++) {
            Dept deptName = opt.get(i).getDept();

            System.out.println(deptName);
        }

    }

    @Test
    @Transactional
    // DB에서 여러개 Table 작업 시 오류가 발생하면 모두 Rollback 시켜주는 기능
    void 조회연습dept() {
        List<Dept> list = deptRepository.findAll();
        Dept dept = list.get(0);
        System.out.println(dept.getEmps());
    }
}
