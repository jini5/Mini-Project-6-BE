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
public class LoanTargetResDTO {

    private String loanTarget; // 대상

    private String loanDescription; // 지원대상 상세조건

    private String age; // 연령

    private String income; // 소득

    private String creditScore; // 신용등급

    private String area; // 거주지역원금균등분할상환

    public LoanTargetResDTO(Loan loan) {
        this.loanTarget = loan.getLoanTarget();
        this.loanDescription = loan.getLoanDescription();
        this.age = loan.getAge();
        this.income = loan.getIncome();
        this.creditScore = loan.getCreditScore();
        this.area = loan.getArea();
    }
}
