package com.mini.money.dto.itemlist;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class CommendResDTO {
    private Long snq;
    private String loanName;
    private String loanLimit;
    private String provider;
    private String[] loanTarget;
    private String area;
    private String rate;
}
