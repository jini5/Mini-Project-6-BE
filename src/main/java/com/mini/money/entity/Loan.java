package com.mini.money.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Table(name = "loan")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class Loan {

    @Id
    @Column(name="laon_id")
    private Long id;

    @Column(name="basYm")
    private String basYm;

    @Column(name="findPrdNm")
    private String findPrdNm;

    @Column(name="lnLmt")
    private String lnLmt;

    @Column(name="irt")
    private String irt;

    @Column(name="maxTotLnTrm")
    private String maxTotLnTrm;

    @Column(name="maxDfmTrm")
    private String maxDfmTrm;

    @Column(name="maxRdptTrm")
    private String maxRdptTrm;

    @Column(name="rdptMthd")
    private String rdptMthd;


}
