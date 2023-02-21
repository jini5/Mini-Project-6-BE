package com.mini.money.service;

import com.mini.money.dto.LoanResDTO;
import com.mini.money.dto.LogInReqDTO;
import com.mini.money.dto.itemlist.CommendResDTO;
import com.mini.money.dto.itemlist.WholeResDTO;
import com.mini.money.parameter.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.HashMap;
import java.util.List;

public interface LoanService {

    List<LoanResDTO> selectLoanList();

    List<WholeResDTO> selectAll(Pageable pageable);

    Page<WholeResDTO> selectByOffice(Office office, Pageable pageable);

    Page<WholeResDTO> selectByArea(Area area, Pageable pageable);

    Page<WholeResDTO> selectByRepayment(Repayment repayment, Pageable pageable);

    Page<WholeResDTO> selectByUsge(Usge usge, Pageable pageable);

    Page<WholeResDTO> selectByTarget(Target target, Pageable pageable);

    Page<WholeResDTO> selectByBaseRate(BaseRate baseRate, Pageable pageable);

    Page<WholeResDTO> selectByMaturity(String maturity, Pageable pageable);

    Page<WholeResDTO> selectByCredit(String credit, Pageable pageable);

    Page<WholeResDTO> selectByKeyword(String keyword, Pageable pageable);

    HashMap<String, Object> selectLoanDetail(Long snq);
    
    List<CommendResDTO> memberCommendLoanList(LogInReqDTO logInReqDTO);

}
