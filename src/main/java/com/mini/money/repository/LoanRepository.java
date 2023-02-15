package com.mini.money.repository;

import com.mini.money.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoanRepository extends JpaRepository<Loan, Long> {


    Optional<Loan> findBySnq(Long snq);
}
