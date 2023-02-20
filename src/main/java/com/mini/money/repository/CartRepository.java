package com.mini.money.repository;

import com.mini.money.entity.Cart;
import com.mini.money.entity.Customer;
import com.mini.money.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

    void deleteByCustomerAndLoan(Customer customer, Loan loan);

    List<Cart> finaAllByCustomer(Customer customer);
}
