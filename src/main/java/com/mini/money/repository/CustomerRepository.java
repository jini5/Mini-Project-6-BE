package com.mini.money.repository;

import com.mini.money.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {

    Customer findByEmail(String email);
}
