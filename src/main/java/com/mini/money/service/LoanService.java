package com.mini.money.service;

import com.mini.money.dto.LoanResDTO;
import com.mini.money.dto.itemlist.WholeResDTO;
import com.mini.money.entity.Loan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface LoanService {

    List<LoanResDTO> selectLoanList();

    List<WholeResDTO> selectAll(Pageable pageable);
}
