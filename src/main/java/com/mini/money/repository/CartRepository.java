package com.mini.money.repository;

import com.mini.money.entity.Cart;
import com.mini.money.entity.Customer;
import com.mini.money.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

    void deleteByCustomerAndLoan(Customer customer, Loan loan);

    List<Cart> findAllByCustomer(Customer customer);
}
