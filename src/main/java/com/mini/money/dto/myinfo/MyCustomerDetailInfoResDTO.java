package com.mini.money.dto.myinfo;

import io.swagger.annotations.ApiModel;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@ApiModel(value = "회원 추가 정보 출력")
public class MyCustomerDetailInfoResDTO {
    private Integer age;
    private String address;
    private String job;
    private String bank;
    private Double crdtGrade;
    private Integer income;
}
