package com.mini.money.dto.cart;

import com.mini.money.entity.Cart;
import com.mini.money.entity.Customer;
import com.mini.money.entity.Loan;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CartReqDTO {

    private String email;

    private Long snq;
    
    public Cart toEntity() {
        return Cart.builder()
                .customer(Customer.builder().email(email).build())
                .loan(Loan.builder().snq(snq).build())
                .build();
    }

}
