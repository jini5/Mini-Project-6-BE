package com.mini.money.controller;

import com.mini.money.dto.LogInReqDTO;
import com.mini.money.entity.Customer;
import com.mini.money.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerDetailControllerTest {

    @Autowired
    CustomerDetailController controller;

    @Autowired
    CustomerRepository cs;

    @Test
    void name() {
        String email = "dong8707@naver.com";
//        LogInReqDTO customer = cs.findByEmail(email);
//        System.out.println(controller.findMyDetailInfo(customer));
    }
}