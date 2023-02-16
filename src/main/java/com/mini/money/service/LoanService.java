package com.mini.money.service;

import com.mini.money.dto.LoanResDTO;
import com.mini.money.dto.LogInReqDTO;
import com.mini.money.dto.itemlist.WholeResDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface LoanService {

    List<LoanResDTO> selectLoanList();

    List<WholeResDTO> selectAll(Pageable pageable);

    List<LoanResDTO> memberCommendLoanList(LogInReqDTO logInReqDTO);

}
