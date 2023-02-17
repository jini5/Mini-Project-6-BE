package com.mini.money.service;

public interface CartService {

    String addCart(Long snq, String email);

    String deleteProduct(String email, Long snq);

}
