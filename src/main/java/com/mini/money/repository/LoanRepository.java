package com.mini.money.repository;

import com.mini.money.entity.Loan;
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

    List<Loan> findAllByAreaContaining(String area, Pageable pageable);

    List<Loan> findAllByAreaNotIn(List<String> areaList, Pageable pageable);

    List<Loan> findAllByRepayMethodContaining(String repayment, Pageable pageable);

    List<Loan> findAllByRepayMethodNotIn(List<String> reapyList, Pageable pageable);

    List<Loan> findAllByUsgeContaining(String usge, Pageable pageable);

    List<Loan> findAllByUsgeNotIn(List<String> usgeList, Pageable pageable);

    List<Loan> findAllByLoanTargetContaining(String loanTarget, Pageable pageable);

    List<Loan> findAllByLoanTargetNotIn(List<String> targetList, Pageable pageable);

    List<Loan> findAllByBaseRateContaining(String baseRate, Pageable pageable);

    List<Loan> findAllByBaseRateNotIn(List<String> baseRateList, Pageable pageable);

    List<Loan> findAllByMaturityNotContaining(String maturity, Pageable pageable);

    List<Loan> findAllByMaturityContaining(String maturity, Pageable pageable);

    List<Loan> findAllByCreditScoreContaining(String credit, Pageable pageable);

    List<Loan> findAllByCreditScoreNotContaining(String credit, Pageable pageable);

    List<Loan> findAllByLoanNameContaining(String keyword, Pageable pageable);
    List<Loan> findAllByAreaContaining(String area);


}
