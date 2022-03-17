package com.example.demo.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@Entity
@ToString(exclude = "team") // 연결고리 끝음
public class Player {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "USERNAME")
    private String name;

    private int age;

    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;

}
