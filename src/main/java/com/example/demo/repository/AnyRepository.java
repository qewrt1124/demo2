package com.example.demo.repository;

import com.example.demo.model.Any;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnyRepository extends JpaRepository<Any, String> {

    List<Any> findBySearch(String search);

    List<Any> findBySearchContaining(String search);
}
