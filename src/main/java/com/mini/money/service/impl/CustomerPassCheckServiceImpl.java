package com.mini.money.service.impl;

import com.mini.money.repository.CustomerRepository;
import com.mini.money.service.CustomerPassCheckService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CustomerPassCheckServiceImpl implements CustomerPassCheckService {

    private final CustomerRepository customerRepository;

    public void checkPassword(String requestPassword, String password) {
        if(!requestPassword.equals(password)){
            throw new IllegalArgumentException();
        }
    }
}
