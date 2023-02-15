package com.mini.money.service.impl;


import com.mini.money.dto.cart.CartReqDTO;
import com.mini.money.repository.CartRepository;
import com.mini.money.repository.LoanRepository;
import com.mini.money.service.CartService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepo;

    private final LoanRepository loanRepo;


    @Override
    public String addCart(Long snq, String email) {
        try {
            cartRepo.save(new CartReqDTO(email, snq).toEntity());
        }catch (Exception err) {
            err.printStackTrace();
            return "failed";
        }
        return "success";
    }
}
