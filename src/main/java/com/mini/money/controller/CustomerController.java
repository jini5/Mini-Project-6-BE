package com.mini.money.controller;

import com.mini.money.dto.CustomerReqDTO;
import com.mini.money.dto.LogInReqDTO;
import com.mini.money.dto.LogInResDTO;
import com.mini.money.dto.myinfo.MyCustomerInfoResDTO;
import com.mini.money.entity.Customer;
import com.mini.money.repository.TokenRepository;
import com.mini.money.service.AuthService;
import com.mini.money.service.CustomerService;
import com.mini.money.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;
    private final AuthService authService;
    private final TokenService tokenService;

    @GetMapping("/mypage/info")
    public ResponseEntity<MyCustomerInfoResDTO> findMyInfo(@AuthenticationPrincipal LogInReqDTO customer) {
        String email = customer.getEmail();
        MyCustomerInfoResDTO myCustomerInfoResDTO = customerService.findMyInfo(email);

        return new ResponseEntity<>(myCustomerInfoResDTO, HttpStatus.OK);
    }

    @PostMapping("/signup")
    public String signUp(@RequestBody CustomerReqDTO signupReqDTO){
        return authService.signup(signupReqDTO);
    }
    @PostMapping("/login")
    public LogInResDTO logIn(@RequestBody LogInReqDTO logInReqDTO){
        return  authService.login(logInReqDTO);
    }

    @PostMapping("/logout")
    public String logOut(@RequestHeader(name = "Authorization") String token){
        tokenService.logout(token);
        return "success";
    }

}
