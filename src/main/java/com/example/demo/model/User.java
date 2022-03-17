package com.example.demo.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class User {

    @Id // Varchar를 PK로 사용하는 것은 좋지 못함
    private String userId;
    private String userPw;
    private String userName;
}

