package com.mini.money.api;

import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class LoanApiTest {

    @Autowired
    LoanApi loanApi;

    @Test
    void name() throws IOException, ParseException {
        loanApi.exampleApi();

    }
}