package com.mini.money.repository;

import com.mini.money.entity.PublicLoan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublicLoanRepository extends JpaRepository<PublicLoan, Long> {
}
