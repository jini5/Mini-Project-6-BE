//package com.mini.money.repository;
//
//import com.mini.money.entity.Customer;
//import com.mini.money.entity.CustomerDetail;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.transaction.annotation.Transactional;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//class CustomerDetailRepositoryTest {
//
//    @Autowired
//    CustomerDetailRepository customerDetailRepository;
//
//    @Autowired
//    CustomerRepository customerRepository;
//
//    @Test
//    @Transactional
//    void name() {
//        String email = "dong8707@naver.com";
//        Customer customer = customerRepository.findByEmail(email);
////        CustomerDetail customerDetail = customerDetailRepository.findByCustomer(customer);
//
////        System.out.println(customerDetail.getCustomer().getEmail());
//    }
//}