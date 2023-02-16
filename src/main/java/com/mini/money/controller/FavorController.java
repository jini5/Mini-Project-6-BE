package com.mini.money.controller;


import com.mini.money.dto.LogInReqDTO;
import com.mini.money.service.FavorService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequiredArgsConstructor
public class FavorController {

    private final FavorService service;

    @PostMapping("/favor")
    public String addFavor(@RequestBody HashMap<String, Object> map, @AuthenticationPrincipal LogInReqDTO customer){
        System.out.println(map);
        String email = customer.getEmail();
        Long snq = Long.valueOf(map.get("snq").toString());
        return service.addFavor(email, snq);
    }
}
