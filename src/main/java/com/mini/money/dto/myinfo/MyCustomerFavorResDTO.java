package com.mini.money.dto.myinfo;


import com.mini.money.entity.Customer;
import com.mini.money.entity.Favor;
import com.mini.money.entity.Loan;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class MyCustomerFavorResDTO {

    private Long id;
    private Customer customer;
    private Loan loan;

    public MyCustomerFavorResDTO(Favor favor) {
        this.id = favor.getId();
        this.customer = favor.getCustomer();
        this.loan = favor.getLoan();
    }
}
