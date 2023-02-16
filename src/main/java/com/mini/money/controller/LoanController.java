package com.mini.money.controller;


import com.mini.money.dto.LoanResDTO;
import com.mini.money.dto.itemlist.WholeResDTO;
import com.mini.money.service.LoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LoanController {

    private final LoanService service;

    @GetMapping("/finance/loan")
    public List<LoanResDTO> selectLoanList() {
        return service.selectLoanList();
    }

    @GetMapping("/finance/itemlist")
    public List<WholeResDTO> allSelectList(Pageable pageable) {
        return service.selectAll(pageable);
    }
}
