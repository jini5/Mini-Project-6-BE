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
public class LoanProdInfoResDTO {

    private String loanName; //상품 이름

    private String usge; // 용도

    private String loanLimit; // 대출한도

    private String rate; // 금리
    private String overdueRate; // 연체이자율


    private String wholePeriod; // 최대총대출기간

    private String gracePeriod; // 최대거치기간

    private String repayPeriod; // 최대상환기관


    private String repayMethod; // 상환방법


    public LoanProdInfoResDTO(Loan loan) {
        this.loanName = loan.getLoanName();
        this.usge = loan.getUsge();
        this.loanLimit = loan.getLoanLimit();
        this.rate = loan.getRate();
        this.overdueRate = loan.getOverdueRate();
        this.wholePeriod = loan.getWholePeriod();
        this.gracePeriod = loan.getGracePeriod();
        this.repayPeriod = loan.getRepayPeriod();
        this.repayMethod = loan.getRepayMethod();
    }
}
