package com.example.demo.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Dept {

    @Id
    @GeneratedValue
    private Short deptno;
    private String dname;
    private String loc;

    @OneToMany(mappedBy = "dept", fetch = FetchType.EAGER)
    List<Emp> emps = new ArrayList<>();
}
