package com.mini.money.repository;

import com.mini.money.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NonLoginRecommendRepository  extends JpaRepository<Loan, Long> {
    List<Loan> findAllBySnq(Long snq);
}
