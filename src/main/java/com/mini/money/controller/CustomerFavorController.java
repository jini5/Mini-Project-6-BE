package com.mini.money.controller;

import com.mini.money.dto.LoanResDTO;
import com.mini.money.entity.Customer;
import com.mini.money.service.impl.CustomerFavorServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class CustomerFavorController {
    private final CustomerFavorServiceImpl customerFavorService;

    @GetMapping("/mypage/favor")
    public List<LoanResDTO> selectFavorList(@AuthenticationPrincipal Customer customer){
        String email = customer.getEmail();
        return customerFavorService.selectFavorList(email);
    }
}
