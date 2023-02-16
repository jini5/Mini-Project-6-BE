package com.mini.money.controller;

import com.mini.money.dto.LogInReqDTO;
import com.mini.money.entity.Customer;
import com.mini.money.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @PostMapping("/cart")
    public String addCart(@RequestBody Long snq, @AuthenticationPrincipal LogInReqDTO customer) {
        String email = customer.getEmail();
        return cartService.addCart(snq, email);
    }
    @DeleteMapping("/cart")
    public String deleteProduct(@AuthenticationPrincipal LogInReqDTO customer, @RequestBody Long id){
        String email = customer.getEmail();
        return cartService.deleteProduct(email, id);
    }
}
