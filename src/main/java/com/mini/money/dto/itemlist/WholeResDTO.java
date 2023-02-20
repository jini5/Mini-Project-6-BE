package com.mini.money.dto.itemlist;

import com.mini.money.entity.Favor;
import com.mini.money.entity.Loan;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class WholeResDTO {
    private Long snq;
    private String loanName;
    private String loanDescription;
    private String[] loanTarget;
    private String baseRate;
    private String rate;

    public WholeResDTO(Loan loan) {
        this.snq = loan.getSnq();
        this.loanName = loan.getLoanName();
        this.loanDescription = loan.getLoanDescription();
        this.loanTarget = loan.getLoanTarget().split(",");
        this.baseRate = loan.getBaseRate();
        this.rate = loan.getRate();
    }
}
