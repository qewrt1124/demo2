package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@Entity
@ToString(exclude = "dept")
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

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "deptno", referencedColumnName = "deptno")
//    @ToString.Exclude
    private Dept dept;
}
