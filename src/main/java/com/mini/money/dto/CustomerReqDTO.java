package com.mini.money.dto;

import com.mini.money.entity.Customer;
import io.swagger.annotations.ApiModel;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@ApiModel(value = "회원 필수 정보 입력")
public class CustomerReqDTO {

    private String email;
    private String password;
    private String name;
    private String phone;

    public Customer toEntity(){
        return Customer.builder()
                .email(this.email)
                .password(this.password)
                .name(this.name)
                .phone(this.phone)
                .build();
    }

}
