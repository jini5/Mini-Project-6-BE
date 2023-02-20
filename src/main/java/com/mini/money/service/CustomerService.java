package com.mini.money.service;

import com.mini.money.dto.myinfo.MyCustomerInfoResDTO;
import com.mini.money.entity.Customer;
import com.mini.money.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;


    public MyCustomerInfoResDTO findMyInfo(String email) {
        Customer customer = customerRepository.findByEmail(email);
        MyCustomerInfoResDTO my = new MyCustomerInfoResDTO(
                customer.getEmail(), customer.getName(), customer.getPhone()
        );
        return my;
    }

    public Map<String, String> checkPassword(String email, String requestPassword) {
        Customer customer = customerRepository.findByEmail(email);
        Map<String, String> customerData = new HashMap<>();
        if (!passwordEncoder.matches(requestPassword, customer.getPassword())) {
            throw new IllegalArgumentException();
        }
        customerData.put("name", customer.getName());
        return customerData;
    }
}
