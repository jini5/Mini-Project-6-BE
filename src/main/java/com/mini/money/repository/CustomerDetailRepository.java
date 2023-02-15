package com.mini.money.repository;

import com.mini.money.entity.Customer;
import com.mini.money.entity.CustomerDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerDetailRepository extends JpaRepository<CustomerDetail, Long> {

    Optional<CustomerDetail> findByCustomer(Customer customer);
}
