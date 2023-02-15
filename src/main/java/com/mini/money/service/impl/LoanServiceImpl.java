package com.mini.money.service.impl;

import com.mini.money.dto.LoanResDTO;
import com.mini.money.entity.Loan;
import com.mini.money.repository.LoanRepository;
import com.mini.money.service.LoanService;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class LoanServiceImpl implements LoanService {

    private final LoanRepository repository;

    @Override
    public List<LoanResDTO> selectLoanList() {
        List<LoanResDTO> list =  repository.findAll()
                .stream()
                .map(res -> new LoanResDTO(Loan.builder()
                        .loanName(res.getLoanName())
                        .loanDescription(res.getLoanDescription())
                        .loanTarget(res.getLoanTarget())
                        .baseRate(res.getBaseRate())
                        .rate(res.getRate())
                        .build()))
                .collect(Collectors.toList());
        List<LoanResDTO> loanList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            int num = (int) (Math.random() * list.size()) + 1;
            loanList.add(list.get(num));
        }
        return loanList;
    }
}
