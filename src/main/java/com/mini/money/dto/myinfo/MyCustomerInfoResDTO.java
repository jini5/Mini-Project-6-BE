package com.mini.money.dto.myinfo;

import io.swagger.annotations.ApiModel;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@ApiModel(value = "회원 필수 정보 출력")
public class MyCustomerInfoResDTO {

    private String email;
    private String name;
    private String phone;

}
