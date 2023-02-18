package com.mini.money.dto.myinfo;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UpdateInfoReqDTO {
    private String password;
    private String phone;
}
