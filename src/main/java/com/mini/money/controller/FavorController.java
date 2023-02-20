package com.mini.money.controller;


import com.mini.money.dto.LogInReqDTO;
import com.mini.money.service.FavorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequiredArgsConstructor
@Api(tags = {"찜 목록"}, description = "찜 목록 상품 추가, 삭제")
public class FavorController {

    private final FavorService service;

    @PostMapping("/favor")
    @ApiOperation(value = "찜 목록 상품 추가", notes = "제품ID(snq)를 통해 찜목록에 상품을 추가한다.")
    public String addFavor(@RequestBody HashMap<String, Object> map, @AuthenticationPrincipal LogInReqDTO customer){
        System.out.println(map);
        String email = customer.getEmail();
        Long snq = Long.valueOf(map.get("snq").toString());
        return service.addFavor(email, snq);
    }


    @DeleteMapping("/favor")
    @ApiOperation(value = "찜 목록 상품 삭제", notes = "제품ID(snq)를 통해 찜목록에 상품을 개별 삭제한다.")
    public String deleteFavor(@AuthenticationPrincipal LogInReqDTO customer, @RequestBody HashMap<String, Object> map) {
        String email = customer.getEmail();
        Long snq = Long.valueOf(map.get("snq").toString());
        return service.deleteFavor(email, snq);
    }
}
