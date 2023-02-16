package com.mini.money.controller;

import com.mini.money.dto.CustomerDetailReqDTO;
import com.mini.money.dto.LogInReqDTO;
import com.mini.money.dto.myinfo.MyCustomerDetailInfoResDTO;
import com.mini.money.entity.Customer;
import com.mini.money.repository.CustomerDetailRepository;
import com.mini.money.service.CustomerDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CustomerDetailController {

    private final CustomerDetailService customerDetailService;

    @PostMapping("/signup/detail")
    public ResponseEntity<String> customerDetailInfo(@RequestBody CustomerDetailReqDTO reqDTO, @AuthenticationPrincipal LogInReqDTO customer) {
        String email = customer.getEmail();
        String message = customerDetailService.customerDetailInfo(email, reqDTO);

        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @GetMapping("/mypage/detail/info")
    public ResponseEntity<Object> findMyDetailInfo(@AuthenticationPrincipal LogInReqDTO customer) {
        String email = customer.getEmail();
        MyCustomerDetailInfoResDTO my = customerDetailService.findMyDetailInfo(email);

        if (my == null) {
            return new ResponseEntity<>("failed", HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(my, HttpStatus.OK);
        }
    }
}
