package com.example.demo.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SunbyulDAO {
  
  @Autowired
  private JdbcTemplate jt;

  public List<Map<String, Object>> Select(int page) {

    return jt.queryForList("SELECT * FROM sunbyul LIMIT ?, 10", page);
  }
}
