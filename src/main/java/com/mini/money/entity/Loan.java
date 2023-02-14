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
    private String basYm;

    @Column(name = "fin_prd_nm")
    private String finPrdNm;

    @Column(name = "ln_lmt")
    private String lnLmt;

    @Column(name = "irt_ctg")
    private String irtCtg;

    @Column(name = "irt")
    private String irt;

    @Column(name = "max_tot_ln_trm")
    private String maxTotLnTrm;

    @Column(name = "max_dfrm_trm")
    private String maxDfrmTrm;

    @Column(name = "max_rdpt_trm")
    private String maxRdptTrm;

    @Column(name = "rdpt_mthd")
    private String rdptMthd;

    @Column(name = "usge")
    private String usge;

    @Column(name = "trgt")
    private String trgt;

    @Column(name = "inst_ctg")
    private String instCtg;

    @Column(name = "ofr_inst_nm")
    private String ofrInstNm;

    @Column(name = "rsd_area_pamt_eglt_istm")
    private String rsdAreaPamtEqltIstm;

    @Column(name = "supr_tgt_dtl_cond")
    private String suprTgtDtlCond;

    @Column(name = "age")
    private String age;

    @Column(name = "incm")
    private String incm;

    @Column(name = "crdt_sc")
    private String crdtSc;

    @Column(name = "grn_inst")
    private String grnInst;

    @Column(name = "jn_mthd")
    private String jnMthd;

    @Column(name = "rpymd_cfe")
    private String rpymdCfe;

    @Column(name = "ln_icdcst")
    private String lnIcdcst;

    @Column(name = "ov_itr_yr")
    private String ovItrYr;

    @Column(name = "prft_add_irt_cond")
    private String prftAddIrtCond;

    @Column(name = "etc_ref_sbjc")
    private String etcRefSbjc;

    @Column(name = "hdl_inst")
    private String hdlInst;

    @Column(name = "cnpl")
    private String cnpl;

    @Column(name = "rlt_site")
    private String rltSite;

    @Column(name = "prd_nm")
    private String prdNm;

    @Column(name = "mgm_dln")
    private String mgmDln;

    @Column(name = "prd_ctg2")
    private String prdCtg2;
}
