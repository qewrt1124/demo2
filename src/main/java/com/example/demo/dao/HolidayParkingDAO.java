package com.example.demo.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class HolidayParkingDAO {
  
  @Autowired
  private JdbcTemplate jt;

  public List<Map<String, Object>> select(int page) {
    return jt.queryForList("SELECT * FROM holiday_parking WHERE gu='금천구' LIMIT ?, 10", page);
  }
}
