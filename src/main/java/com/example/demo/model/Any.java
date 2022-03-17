package com.example.demo.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity(name = "any2")
public class Any {

    @Id
    String name;
    Integer age;
    String search;
}
