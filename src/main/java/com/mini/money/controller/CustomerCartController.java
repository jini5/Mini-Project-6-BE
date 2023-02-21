package com.mini.money.controller;

import com.mini.money.dto.LoanResDTO;
import com.mini.money.dto.LogInReqDTO;
import com.mini.money.service.CartService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Api(tags = {"회원 장바구니"})
public class CustomerCartController {

    private final CartService cartService;

    @GetMapping("/mypage/cart")
    @ApiOperation(value = "장바구니 확인", notes = "회원의 장바구니를 확인한다.")
    public List<LoanResDTO> selectCartList(@AuthenticationPrincipal LogInReqDTO logInReqDTO){
        String email = logInReqDTO.getEmail();
        return cartService.selectCartList(email);
    }
}
