package com.mini.money.entity;


import javax.persistence.*;

@Entity
@Table(name = "favor")
public class Favor {

    @Id
    @Column(name = "favor_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "email")
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "snq")
    private Loan loan;





}
