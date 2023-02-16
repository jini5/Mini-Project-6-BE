package com.mini.money.service;

import com.mini.money.dto.CustomerReqDTO;

public interface AuthService {
    String signup(CustomerReqDTO signupReqDTO);
}
