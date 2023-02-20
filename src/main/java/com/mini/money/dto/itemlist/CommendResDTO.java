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
    private String loanDescription;
    private String[] loanTarget;
    private String baseRate;
    private String rate;
    private String area;
}