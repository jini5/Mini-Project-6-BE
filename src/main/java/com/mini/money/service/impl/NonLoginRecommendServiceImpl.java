package com.mini.money.service.impl;

import com.mini.money.dto.LoanResDTO;
import com.mini.money.dto.NonLoginRecommendResDTO;
import com.mini.money.entity.Loan;
import com.mini.money.repository.NonLoginRecommendRepository;
import com.mini.money.service.NonLoginRecommendService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NonLoginRecommendServiceImpl implements NonLoginRecommendService {

    private final NonLoginRecommendRepository repository;

    @Override
    public List<NonLoginRecommendResDTO> selectRecommendList() {
        List<NonLoginRecommendResDTO> list = repository.findAll()
                .stream()
                .map(res -> new NonLoginRecommendResDTO(Loan.builder()
                        .snq(res.getSnq())
                        .loanName(res.getLoanName())
                        .rate(res.getRate())
                        .loanTarget(res.getLoanTarget())
                        .loanLimit(res.getLoanLimit())
                        .userOffice(res.getUserOffice())
                        .build()))
                .collect(Collectors.toList());
        List<NonLoginRecommendResDTO> loanList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            int num = (int) (Math.random() * list.size()) + 1;
            loanList.add(list.get(num));
        }
        return loanList;
    }
}
