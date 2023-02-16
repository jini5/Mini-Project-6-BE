package com.mini.money.service.impl;

import com.mini.money.dto.favor.FavorReqDTO;
import com.mini.money.entity.Customer;
import com.mini.money.entity.Favor;
import com.mini.money.entity.Loan;
import com.mini.money.repository.CustomerRepository;
import com.mini.money.repository.FavorRepository;
import com.mini.money.repository.LoanRepository;
import com.mini.money.service.FavorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FavorServiceImpl implements FavorService {

    private final FavorRepository favorRepo;

    private final CustomerRepository customerRepo;

    private final LoanRepository loanRepo;


    @Override
    public String addFavor(String email, Long snq) {
        Customer customer = customerRepo.findByEmail(email);
        Loan loan = loanRepo.findBySnq(snq).orElse(null);
        try {
            favorRepo.save(new FavorReqDTO().toEntity(customer, loan));
        }catch (Exception err) {
            err.printStackTrace();
            return "failed";
        }
        return "success";






    }
}
