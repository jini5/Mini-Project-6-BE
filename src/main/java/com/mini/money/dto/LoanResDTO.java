package com.mini.money.dto;
import com.mini.money.entity.Loan;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LoanResDTO {

    private Long snq;

    private String baseDate; // 기준년월

    private String loanName; // 금융상품명

    private String loanLimit; // 대출한도

    private String baseRate; // 금리구분

    private String rate; // 금리

    private String wholePeriod; // 최대총대출기간

    private String gracePeriod; // 최대거치기간

    private String repayPeriod; // 최대상환기관

    private String repayMethod; // 상환방법

    private String usge; // 용도

    private String[] loanTarget; // 대상

    private String divisionOffice; // 기관구분

    private String provider; // 제공기관명

    private String area; // 거주지역원금균등분할상환

    private String loanDescription; // 지원대상 상세조건

    private String age; // 연령

    private String income; // 소득

    private String creditScore; // 신용등급

    private String trustOffice; // 보증기관

    private String joinMethod; // 가입(신청)방법

    private String earlyRedemptionFee; // 중도상환수수료

    private String addCost; // 대출부대비용

    private String overdueRate; // 연체이자율

    private String primeCondition; // 우대금리/가산금리 조건

    private String etcNote; // 기타참고사항

    private String userOffice; // 취급기관

    private String contact; // 연락처

    private String homepage; // 관련사이트

    private String loanClassification; // 상품 분류

    private String maturity; // 운영기한

    private String loanType; // 상품타입

    public LoanResDTO(Loan loan) {
        this.snq = loan.getSnq();
        this.baseDate = loan.getBaseDate();
        this.loanName = loan.getLoanName();
        this.loanLimit = loan.getLoanLimit();
        this.baseRate = loan.getBaseRate();
        this.rate = loan.getRate();
        this.wholePeriod = loan.getWholePeriod();
        this.gracePeriod = loan.getGracePeriod();
        this.repayPeriod = loan.getRepayPeriod();
        this.repayMethod = loan.getRepayMethod();
        this.usge = loan.getUsge();
        this.loanTarget = loan.getLoanTarget().split(",");
        this.divisionOffice = loan.getDivisionOffice();
        this.provider = loan.getProvider();
        this.area = loan.getArea();
        this.loanDescription = loan.getLoanDescription();
        this.age = loan.getAge();
        this.income = loan.getIncome();
        this.creditScore = loan.getCreditScore();
        this.trustOffice = loan.getTrustOffice();
        this.joinMethod = loan.getJoinMethod();
        this.earlyRedemptionFee = loan.getEarlyRedemptionFee();
        this.addCost = loan.getAddCost();
        this.overdueRate = loan.getOverdueRate();
        this.primeCondition = loan.getPrimeCondition();
        this.etcNote = loan.getEtcNote();
        this.userOffice = loan.getUserOffice();
        this.contact = loan.getContact();
        this.homepage = loan.getHomepage();
        this.loanClassification = loan.getLoanClassification();
        this.maturity = loan.getMaturity();
        this.loanType = loan.getLoanType();
    }
}
