package com.mini.money.dto.myinfo;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class MyCustomerDetailInfoResDTO {
    private Integer age;
    private String address;
    private String job;
    private String bank;
    private Double crdtGrade;
    private Integer income;
}
