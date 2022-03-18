package com.example.demo;

import com.example.demo.model.Order;
import com.example.demo.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class OrderRepositoryTest {

    @Autowired
    OrderRepository orderRepository;

    @Test
    void 조회Test() {
        List<Order> list = orderRepository.findAll();

        Order order = list.get(0);
        System.out.println(order);

    }
}
