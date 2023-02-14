package com.mini.money.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "public_loan")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@ToString
public class PublicLoan {
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


//    public PublicLoan(String snq, String basYm, String finPrdNm, String lnLmt,
//                      String irtCtg, String irt, String maxTotLnTrm, String maxDfrmTrm,
//                      String maxRdptTrm, String rdptMthd, String usge, String trgt,
//                      String instCtg, String ofrInstNm, String rsdAreaPamtEqltIstm, String suprTgtDtlCond,
//                      String age, String incm, String rsdArea, String crdtSc,
//                      String anin, String housHoldCnt, String housAr, String lnTgtHous,
//                      String rfrcCnpl, String grnInst, String jnMthd, String rpymdCfe,
//                      String lnIcdcst, String ovItrYr, String prftAddIrtCond, String etcRefSbjc,
//                      String hdlInst, String cnpl, String rltSite, String tgtFltr,
//                      String hdlInstDtlVw, String prdExisYn, String prdCtg, String prdNm,
//                      String mgmDln, String prdCtg2) {
//
//        this.snq = snq;
//        this.basYm = basYm;
//        this.finPrdNm = finPrdNm;
//        this.lnLmt = lnLmt;
//        this.irtCtg = irtCtg;
//        this.irt = irt;
//        this.maxTotLnTrm = maxTotLnTrm;
//        this.maxDfrmTrm = maxDfrmTrm;
//        this.maxRdptTrm = maxRdptTrm;
//        this.rdptMthd = rdptMthd;
//        this.usge = usge;
//        this.trgt = trgt;
//        this.instCtg = instCtg;
//        this.ofrInstNm = ofrInstNm;
//        this.rsdAreaPamtEqltIstm = rsdAreaPamtEqltIstm;
//        this.suprTgtDtlCond = suprTgtDtlCond;
//        this.age = age;
//        this.incm = incm;
//        this.rsdArea = rsdArea;
//        this.crdtSc = crdtSc;
//        this.anin = anin;
//        this.housHoldCnt = housHoldCnt;
//        this.housAr = housAr;
//        this.lnTgtHous = lnTgtHous;
//        this.rfrcCnpl = rfrcCnpl;
//        this.grnInst = grnInst;
//        this.jnMthd = jnMthd;
//        this.rpymdCfe = rpymdCfe;
//        this.lnIcdcst = lnIcdcst;
//        this.ovItrYr = ovItrYr;
//        this.prftAddIrtCond = prftAddIrtCond;
//        this.etcRefSbjc = etcRefSbjc;
//        this.hdlInst = hdlInst;
//        this.cnpl = cnpl;
//        this.rltSite = rltSite;
//        this.tgtFltr = tgtFltr;
//        this.hdlInstDtlVw = hdlInstDtlVw;
//        this.prdExisYn = prdExisYn;
//        this.prdCtg = prdCtg;
//        this.prdNm = prdNm;
//        this.mgmDln = mgmDln;
//        this.prdCtg2 = prdCtg2;
//
//    }
}
