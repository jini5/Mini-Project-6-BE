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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fin_prdt_cd_loan", referencedColumnName = "fin_prdt_cd")
    private Loan loan;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fin_prdt_cd_deposit", referencedColumnName = "fin_prdt_cd")
    private Deposit deposit;





}
