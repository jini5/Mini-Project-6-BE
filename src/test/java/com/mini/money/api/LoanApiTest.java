package com.mini.money.api;

import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PublicLoanApiTest {

    @Autowired
    PublicLoanApi publicLoanApi;

    @Test
    void name() throws IOException, ParseException {
        publicLoanApi.exampleApi();

    }
}