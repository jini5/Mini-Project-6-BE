package com.mini.money.service;

import org.springframework.http.ResponseEntity;

public interface TokenService {

    ResponseEntity logout(String header);

    boolean checkBlacklist(String token);

}
