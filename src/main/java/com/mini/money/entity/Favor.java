package com.mini.money.entity;


import javax.persistence.*;

@Entity
@Table(name = "favor")
public class Favor {

    @Id
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Customer customer;








}
