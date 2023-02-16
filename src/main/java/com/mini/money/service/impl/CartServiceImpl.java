package com.mini.money.service.impl;


import com.mini.money.dto.cart.CartReqDTO;
import com.mini.money.entity.Customer;
import com.mini.money.entity.Loan;
import com.mini.money.repository.CartRepository;
import com.mini.money.repository.CustomerRepository;
import com.mini.money.repository.LoanRepository;
import com.mini.money.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepo;
    private final CustomerRepository customerRepo;
    private final LoanRepository loanRepo;


    @Override
    public String addCart(Long snq, String email) {
        Loan loan = loanRepo.findBySnq(snq).orElse(null);
        Customer customer = customerRepo.findByEmail(email);
        try {
            cartRepo.save(new CartReqDTO().toEntity(customer, loan));
        }catch (Exception err) {
            err.printStackTrace();
            return "failed";
        }
        return "success";
    }
}
