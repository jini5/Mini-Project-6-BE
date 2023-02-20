package com.mini.money.controller;

import com.mini.money.dto.LoanResDTO;
import com.mini.money.dto.LogInReqDTO;
import com.mini.money.service.FavorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@Api(tags = {"찜 목록"}, description = "회원 찜 목록 확인")
public class CustomerFavorController {
    private final FavorService favorService;

    @GetMapping("/mypage/favor")
    @ApiOperation(value = "내 찜 목록", notes = "회원의 찜 목록을 확인한다.")
    public List<LoanResDTO> selectFavorList(@AuthenticationPrincipal LogInReqDTO logInReqDTO){
        String email = logInReqDTO.getEmail();
        return favorService.selectFavorList(email);
    }
}
