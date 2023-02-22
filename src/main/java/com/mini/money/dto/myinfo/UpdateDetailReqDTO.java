package com.mini.money.dto.myinfo;


import io.swagger.annotations.ApiModel;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@ApiModel(value = "회원 상세 정보 수정")
public class UpdateDetailReqDTO {

    private Integer age;

    private String address;

    private String job;

    private String bank;

    private Double crdtGrade;

    private Integer income;

}
