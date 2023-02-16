package com.mini.money.repository;

import com.mini.money.entity.Loan;
import com.mini.money.parameter.Office;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {

    Optional<Loan> findBySnq(Long snq);

    List<Loan> findAllByDivisionOfficeContaining(String office, Pageable pageable);

    List<Loan> findAllByDivisionOfficeNotIn(List<String> officeList, Pageable pageable);

}
