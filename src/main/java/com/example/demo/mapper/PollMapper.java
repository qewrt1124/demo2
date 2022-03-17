package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface PollMapper {
	
	public Integer insert(Map<String,Object> map);
}
