package com.mini.money.service;

import com.mini.money.dto.LoanResDTO;

import java.util.List;


public interface CartService {

    String addCart(Long snq, String email);

    String deleteProduct(String email, Long snq);

    List<LoanResDTO> selectCartList(String email);
}
