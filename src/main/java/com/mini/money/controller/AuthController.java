package com.mini.money.controller;

import com.mini.money.dto.CustomerReqDTO;
import com.mini.money.dto.LogInReqDTO;
import com.mini.money.dto.LogInResDTO;
import com.mini.money.entity.Blacklist;
import com.mini.money.repository.TokenRepository;
import com.mini.money.service.CustomerService;
import com.mini.money.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final CustomerService customerService;
    private final TokenService tokenService;
    private final TokenRepository tokenRepository;


    @PostMapping("/signup")
    public String signUp(CustomerReqDTO signupReqDTO){
        return customerService.signup(signupReqDTO);
    }

    @PostMapping("/login")
    public LogInResDTO logIn(LogInReqDTO logInReqDTO){
        return customerService.login(logInReqDTO);
    }
///https://fa466e8e-2ce8-447d-b2dd-517832056015.mock.pstmn.io
    @PostMapping("/logout")
    public String logOut(@RequestHeader(name = "Authorization") String token){
       tokenService.logout(token);
       return "success";
    }


}
