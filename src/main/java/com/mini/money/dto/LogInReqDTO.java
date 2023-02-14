package com.mini.money.dto;

import com.mini.money.entity.Customer;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class LogInReqDTO {

    private String email;
    private String password;

    public Customer toEntity(){
        return Customer.builder()
                .email(this.email)
                .password(this.password)
                .build();
    }
}
