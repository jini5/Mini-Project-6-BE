package com.mini.money.controller;

import com.mini.money.dto.LogInReqDTO;
import com.mini.money.entity.Customer;
import com.mini.money.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @PostMapping("/cart")
    public String addCart(@RequestBody HashMap<String, Object> map,  @AuthenticationPrincipal LogInReqDTO customer) {
        System.out.println(map);
        String email = customer.getEmail();
        Long snq = Long.valueOf(map.get("snq").toString());
        return cartService.addCart(snq, email);
    }
    @DeleteMapping("/cart")
    public String deleteProduct(@AuthenticationPrincipal LogInReqDTO customer, @RequestBody HashMap<String, Object> map){
        Long snq = Long.valueOf(map.get("snq").toString());
        String email = customer.getEmail();
        return cartService.deleteProduct(email, snq);
    }
}
