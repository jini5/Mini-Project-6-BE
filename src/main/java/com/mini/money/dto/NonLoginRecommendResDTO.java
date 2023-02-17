package com.mini.money.dto;

import com.mini.money.entity.Loan;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class NonLoginRecommendResDTO {
    private Long snq;
    private String loanName;
    private String loanLimit;
    private String rate;
    private String loanTarget;
    private String userOffice;

    public NonLoginRecommendResDTO(Loan loan){
        this.snq = loan.getSnq();
        this.loanName = loan.getLoanName();
        this.loanLimit = loan.getLoanLimit();
        this.rate = loan.getRate();
        this.loanTarget = loan.getLoanTarget();
        this.userOffice = loan.getUserOffice();
    }
}
