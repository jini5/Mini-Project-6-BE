package com.mini.money.controller;

import com.mini.money.dto.LoanResDTO;
import com.mini.money.dto.LogInReqDTO;
import com.mini.money.service.impl.FavorServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CustomerFavorController {
    private final FavorServiceImpl FavorService;

    @GetMapping("/mypage/favor")
    public List<LoanResDTO> selectFavorList(@AuthenticationPrincipal LogInReqDTO logInReqDTO){
        String email = logInReqDTO.getEmail();
        System.out.println(email);
        return FavorService.selectFavorList(email);
    }
}
