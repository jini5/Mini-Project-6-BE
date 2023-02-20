package com.mini.money.dto.myinfo;

import io.swagger.annotations.ApiModel;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@ApiModel(value = "회원 정보 수정")
public class UpdateInfoReqDTO {
    private String password;
    private String phone;
}
