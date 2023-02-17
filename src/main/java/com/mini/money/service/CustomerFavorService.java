package com.mini.money.service;

import com.mini.money.dto.LoanResDTO;

import java.util.List;

public interface CustomerFavorService {
    List<LoanResDTO> selectFavorList(String email);

}
