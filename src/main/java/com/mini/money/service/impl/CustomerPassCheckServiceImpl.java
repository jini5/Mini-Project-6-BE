package com.mini.money.service.impl;

import com.mini.money.entity.Customer;
import com.mini.money.repository.CustomerRepository;
import com.mini.money.service.CustomerPassCheckService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

@RequiredArgsConstructor
public class CustomerPassCheckServiceImpl implements CustomerPassCheckService {

    private final CustomerRepository customerRepository;

    private final PasswordEncoder passwordEncoder;


    public String checkPassword(String requestPassword, String email) {
        Customer customer = customerRepository.findByEmail(email);
        requestPassword = encodingPassword(requestPassword);
        if(!requestPassword.equals(customer.getPassword())){
            throw new IllegalArgumentException();
        }
            return customer.getEmail();

    }

    private String encodingPassword(String password) {
        return passwordEncoder.encode(password);
    }
}
