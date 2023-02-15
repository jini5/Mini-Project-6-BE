package com.mini.money.service;

import com.mini.money.dto.LoanResDTO;

import java.util.List;

public interface LoanService {

    List<LoanResDTO> selectLoanList();

}
