package com.mini.money.service;

import com.mini.money.dto.myinfo.MyCustomerInfoResDTO;
import com.mini.money.entity.Customer;
import com.mini.money.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public MyCustomerInfoResDTO findMyInfo(String email) {
        Customer customer = customerRepository.findByEmail(email);
        MyCustomerInfoResDTO my = new MyCustomerInfoResDTO(
                customer.getEmail(), customer.getName(), customer.getPhone()
        );
        return my;
    }
}
