package com.mini.money.repository;

import com.mini.money.entity.Loan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {

    Optional<Loan> findBySnq(Long snq);

    Page<Loan> findAllByDivisionOfficeContaining(String office, Pageable pageable);

    Page<Loan> findAllByDivisionOfficeNotIn(List<String> officeList, Pageable pageable);

    Page<Loan> findAllByAreaContaining(String area, Pageable pageable);

    Page<Loan> findAllByAreaNotIn(List<String> areaList, Pageable pageable);

    Page<Loan> findAllByRepayMethodContaining(String repayment, Pageable pageable);

    Page<Loan> findAllByRepayMethodNotIn(List<String> reapyList, Pageable pageable);

    Page<Loan> findAllByUsgeContaining(String usge, Pageable pageable);

    Page<Loan> findAllByUsgeNotIn(List<String> usgeList, Pageable pageable);

    Page<Loan> findAllByLoanTargetContaining(String loanTarget, Pageable pageable);

    Page<Loan> findAllByLoanTargetNotIn(List<String> targetList, Pageable pageable);

    Page<Loan> findAllByBaseRateContaining(String baseRate, Pageable pageable);

    Page<Loan> findAllByBaseRateNotIn(List<String> baseRateList, Pageable pageable);

    Page<Loan> findAllByMaturityNotContaining(String maturity, Pageable pageable);

    Page<Loan> findAllByMaturityContaining(String maturity, Pageable pageable);

    Page<Loan> findAllByCreditScoreContaining(String credit, Pageable pageable);

    Page<Loan> findAllByCreditScoreNotContaining(String credit, Pageable pageable);

    Page<Loan> findAllByLoanNameContaining(String keyword, Pageable pageable);

}
