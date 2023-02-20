package com.mini.money.dto.loan;

import com.mini.money.entity.Loan;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoanEtcResDTO {

    private String provider; // 제공기관명

    private String userOffice; // 취급기관

    private String contact; // 연락처

    private String joinMethod; // 가입(신청)방법

    private String earlyRedemptionFee; // 중도상환수수료

    private String primeCondition; //우대금리/가산금리 조건

    private String etcNode; // 기타 참고사항

    private String homepage; //관련 사이트

    public LoanEtcResDTO(Loan loan) {
        this.provider = loan.getProvider();
        this.userOffice = loan.getUserOffice();
        this.etcNode = loan.getEtcNote();
        this.homepage = loan.getHomepage();
        this.primeCondition = loan.getPrimeCondition();
        this.contact = loan.getContact();
        this.joinMethod = loan.getJoinMethod();
        this.earlyRedemptionFee = loan.getEarlyRedemptionFee();
    }
}
