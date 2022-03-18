package com.example.demo.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Data
@Entity
public class Order {

    @Id
    @Column(length = 11)
    private Integer id;

    @Column(length = 30)
    private String name;

    @Column(length = 11)
    private Integer count;

    @Column(length = 30)
    private String dest;

    @Temporal(TemporalType.DATE)
    private Date ordDate;

    // name => 상대방 객체명_PK명
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    @ManyToOne
    private Customer customer;
}
