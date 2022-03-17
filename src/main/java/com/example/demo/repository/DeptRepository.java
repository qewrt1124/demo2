package com.example.demo.repository;

import com.example.demo.model.Dept;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeptRepository extends JpaRepository<Dept, Short> {

}
