package com.example.demo.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Customer {

    @Id
    @Column(length = 20)
    String id;

    @Column(length = 10)
    String name;

    @Column(length = 11)
    Integer age;

    @Column(length = 10)
    String grade;

    @Column(length = 20)
    String job;

    @Column(length = 11)
    Integer point;

}
