package com.example.demo.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@Entity
public class Emp {

    @Id
    @GeneratedValue
    private Integer empno;
    private String ename;
    private String job;
    private Integer mgr;
    private String hiredate;
    private Integer sal;
    private Integer comm;

    @ManyToOne
    @JoinColumn(name = "deptno")
    private Dept dept;
}
