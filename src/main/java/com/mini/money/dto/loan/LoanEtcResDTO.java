package com.mini.money.dto.loan;

import com.mini.money.entity.Loan;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

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

    public LoanEtcResDTO(Loan loan) {
        this.provider = loan.getProvider();
        this.userOffice = loan.getUserOffice();
        this.contact = loan.getContact();
        this.joinMethod = loan.getJoinMethod();
        this.earlyRedemptionFee = loan.getEarlyRedemptionFee();
    }
}
