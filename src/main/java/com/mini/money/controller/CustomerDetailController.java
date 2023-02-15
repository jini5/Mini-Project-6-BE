package com.mini.money.controller;

import com.mini.money.dto.CustomerDetailReqDTO;
import com.mini.money.entity.Customer;
import com.mini.money.service.CustomerDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CustomerDetailController {

    private final CustomerDetailService customerDetailService;

    @PostMapping("/signup/detail")
    public ResponseEntity<String> customerDetailInfo(@RequestBody CustomerDetailReqDTO reqDTO, @AuthenticationPrincipal Customer customer) {
        String email = customer.getEmail();
        String message = customerDetailService.customerDetailInfo(email, reqDTO);

        return new ResponseEntity<>(message, HttpStatus.OK);
    }


}
