package com.mini.money.service;

import com.mini.money.dto.CustomerDetailReqDTO;
import com.mini.money.entity.Customer;
import com.mini.money.entity.CustomerDetail;
import com.mini.money.repository.CustomerDetailRepository;
import com.mini.money.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerDetailService {

    private final CustomerDetailRepository customerDetailRepository;
    private final CustomerRepository customerRepository;

    public String customerDetailInfo(String email, CustomerDetailReqDTO reqDTO) {
        Customer loginCustomer = customerRepository.findByEmail(email);
        CustomerDetail customerDetail = reqDTO.toEntity(loginCustomer);
        customerDetailRepository.save(customerDetail);

        return "success";
    }
}
