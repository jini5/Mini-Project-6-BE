package com.mini.money.dto;


import com.mini.money.entity.Customer;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(value = "로그인 후 토큰 출력")
public class LogInResDTO {
    private String email;
    private String name;
    private String token;

    private String message;

    public LogInResDTO(Customer customer, String token){
        this.email = customer.getEmail();
        this.name = customer.getName();
        this.token = token;
    }

    public LogInResDTO(String message){
        this.message = message;
    }

}
