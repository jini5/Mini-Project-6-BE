package com.mini.money.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Table(name = "public_loan")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class Loan {
    @Id
    @Column(name = "snq")
    private Long snq;

    @Column(name = "bas_ym")
    private String baseDate; // 기준년월

    @Column(name = "fin_prd_nm")
    private String loanName; // 금융상품명

    @Column(name = "ln_lmt")
    private String loanLimit; // 대출한도

    @Column(name = "irt_ctg")
    private String baseRate; // 금리구분

    @Column(name = "irt")
    private String rate; // 금리

    @Column(name = "max_tot_ln_trm")
    private String wholePeriod; // 최대총대출기간

    @Column(name = "max_dfrm_trm")
    private String gracePeriod; // 최대거치기간

    @Column(name = "max_rdpt_trm")
    private String repayPeriod; // 최대상환기관

    @Column(name = "rdpt_mthd")
    private String repayMethod; // 상환방법

    @Column(name = "usge")
    private String usge; // 용도

    @Column(name = "trgt")
    private String loanTarget; // 대상

    @Column(name = "inst_ctg")
    private String divisionOffice; // 기관구분

    @Column(name = "ofr_inst_nm")
    private String provider; // 제공기관명

    @Column(name = "rsd_area_pamt_eglt_istm")
    private String area; // 거주지역원금균등분할상환

    @Column(name = "supr_tgt_dtl_cond")
    private String loanDescription; // 지원대상 상세조건

    @Column(name = "age")
    private String age; // 연령

    @Column(name = "incm")
    private String income; // 소득

    @Column(name = "crdt_sc")
    private String creditScore; // 신용등급

    @Column(name = "grn_inst")
    private String trustOffice; // 보증기관

    @Column(name = "jn_mthd")
    private String joinMethod; // 가입(신청)방법

    @Column(name = "rpymd_cfe")
    private String earlyRedemptionFee; // 중도상환수수료

    @Column(name = "ln_icdcst")
    private String addCost; // 대출부대비용

    @Column(name = "ov_itr_yr")
    private String overdueRate; // 연체이자율

    @Column(name = "prft_add_irt_cond")
    private String primeCondition; // 우대금리/가산금리 조건

    @Column(name = "etc_ref_sbjc")
    private String etcNote; // 기타참고사항

    @Column(name = "hdl_inst")
    private String userOffice; // 취급기관

    @Column(name = "cnpl")
    private String contact; // 연락처

    @Column(name = "rlt_site")
    private String homepage; // 관련사이트

    @Column(name = "prd_nm")
    private String loanClassification; // 상품 분류

    @Column(name = "mgm_dln")
    private String maturity; // 운영기한

    @Column(name = "prd_ctg2")
    private String loanType; // 상품타입
}
