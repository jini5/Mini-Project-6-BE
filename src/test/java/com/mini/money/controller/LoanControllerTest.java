package com.mini.money.controller;

import com.mini.money.parameter.Office;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LoanControllerTest {

    @Autowired
    LoanController loanController;

    @Test
    void name() {
        Pageable pageable = PageRequest.of(0, 10);
        Office office = Office.은행;

        System.out.println(loanController.selectByOffice(office, pageable));
    }
}