package com.mini.money.service;

import com.mini.money.dto.LoanResDTO;
import com.mini.money.dto.itemlist.WholeResDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface FavorService {

    String addFavor(String email, Long snq);

    String deleteFavor(String email, Long snq);

    List<LoanResDTO> selectFavorList(String email);

    Page<WholeResDTO> popularList();
}
