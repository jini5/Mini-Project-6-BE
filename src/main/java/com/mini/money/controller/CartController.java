package com.mini.money.controller;

import com.mini.money.entity.Customer;
import com.mini.money.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @PostMapping("/cart")
    public String addCart(@PathVariable("snq") Long snq, @AuthenticationPrincipal Customer customer) {
        String email = customer.getEmail();
        return cartService.addCart(snq, email);
    }

}
