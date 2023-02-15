package com.mini.money.dto.myinfo;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class MyCustomerInfoResDTO {

    private String email;
    private String name;
    private String phone;

}
