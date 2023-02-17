package com.mini.money.service;

import com.mini.money.dto.LoanResDTO;
import com.mini.money.dto.itemlist.WholeResDTO;
import com.mini.money.parameter.*;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface LoanService {

    List<LoanResDTO> selectLoanList();

    List<WholeResDTO> selectAll(Pageable pageable);

    List<WholeResDTO> selectByOffice(Office office, Pageable pageable);

    List<WholeResDTO> selectByArea(Area area, Pageable pageable);

    List<WholeResDTO> selectByRepayment(Repayment repayment, Pageable pageable);

    List<WholeResDTO> selectByUsge(Usge usge, Pageable pageable);

    List<WholeResDTO> selectByTarget(Target target, Pageable pageable);

    List<WholeResDTO> selectByBaseRate(BaseRate baseRate, Pageable pageable);

    List<WholeResDTO> selectByMaturity(String maturity, Pageable pageable);

    List<WholeResDTO> selectByCredit(String credit, Pageable pageable);

    List<WholeResDTO> selectByKeyword(String keyword, Pageable pageable);

}
