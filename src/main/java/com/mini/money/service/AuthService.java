package com.mini.money.service;

import com.mini.money.dto.CustomerReqDTO;
import com.mini.money.dto.LogInReqDTO;
import com.mini.money.dto.LogInResDTO;

public interface AuthService {
    String signup(CustomerReqDTO signupReqDTO);

    LogInResDTO login(LogInReqDTO logInReqDTO);
}
