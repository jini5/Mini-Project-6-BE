package com.mini.money.service;

import com.mini.money.dto.LoanResDTO;

import java.util.List;

public interface FavorService {

    String addFavor(String email, Long snq);

    String deleteFavor(String email, Long snq);

    List<LoanResDTO> selectFavorList(String email);

}
