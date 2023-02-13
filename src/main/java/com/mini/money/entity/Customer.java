package com.mini.money.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class Customer {

    @Id
    @Column(name = "user_id")
    private String userId;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "phone")
    private String phone;

    @Column(name = "postcode")
    private String postcode;

    @Column(name = "address")
    private String address;

    @Column(name = "address_detail")
    private String address_detail;

    @Column(name = "age")
    private String age;

    @Column(name = "job")
    private String job;

    @Column(name = "income")
    private int income;

    @Column(name = "crdt_grad")
    private int creditGrade;

    @Column(name = "role")
    private String role;

    @Column(name = "bank")
    private String bank;




}
