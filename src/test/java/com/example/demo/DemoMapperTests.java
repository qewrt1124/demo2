package com.example.demo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.demo.mapper.DemoMapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoMapperTests {

	@Autowired
	private DemoMapper demoMapper;

	@Test
	public void select() {

		List<Map<String, Object>> result = demoMapper.select();

		System.out.println(result);
	}

	@Test
	public void insert() {
		Map<String, Object> map = new HashMap<>();

		map.put("seq", 4);
		map.put("user", "DDD");

		demoMapper.insert(map);
	}
}
