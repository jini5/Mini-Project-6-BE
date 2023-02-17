package com.mini.money.service.impl;

import com.mini.money.dto.LoanResDTO;
import com.mini.money.entity.Favor;
import com.mini.money.entity.Loan;
import com.mini.money.repository.CustomerFavorRepository;
import com.mini.money.repository.CustomerRepository;
import com.mini.money.repository.LoanRepository;
import com.mini.money.service.CustomerFavorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CustomerFavorServiceImpl implements CustomerFavorService {

    private final CustomerFavorRepository favorRepository;

    private final CustomerRepository customerRepository;

    private final LoanRepository loanRepository;

    @Override
    public List<LoanResDTO> selectFavorList(String email){
        Optional<Favor> favor = favorRepository.findByEmail(email);
        List<LoanResDTO> list = loanRepository.findAllBySnq(favor.get().getLoan().getSnq())
                .stream()
                .map(res -> new LoanResDTO(Loan.builder()
                        .snq(res.getSnq())
                        .loanName(res.getLoanName())
                        .loanLimit(res.getLoanLimit())
                        .loanTarget(res.getLoanTarget())
                        .userOffice(res.getUserOffice())
                        .rate(res.getRate())
                        .build()))
                .collect(Collectors.toList());
        return list;
    }


}
