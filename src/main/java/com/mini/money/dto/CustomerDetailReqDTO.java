package com.mini.money.dto;

import com.mini.money.entity.Customer;
import com.mini.money.entity.CustomerDetail;
import lombok.*;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class CustomerDetailReqDTO {

    private Long id;

    private Customer customer;

    private int age;

    private String address;

    private String job;

    private String bank;

    private Double crdtGrade;

    private int income;


    public CustomerDetail toEntity(){
        return CustomerDetail.builder()
                .customer(this.customer)
                .age(this.age)
                .address(this.address)
                .job(this.job)
                .bank(this.bank)
                .crdtGrade(this.crdtGrade)
                .income(this.income)
                .build();
    }
}
