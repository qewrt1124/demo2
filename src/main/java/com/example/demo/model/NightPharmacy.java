package com.example.demo.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class NightPharmacy {
    @Id
    @GeneratedValue
    Integer id;
    String name;
    String tel;
    String roadAddress;
    String jibunAddress;
    String mon;
    String tue;
    String wed;
    String thu;
    String fri;
    String sat;
    String sun;
    String pub_day;
}
