package com.mini.money.controller;

import com.mini.money.dto.CustomerDetailReqDTO;
import com.mini.money.dto.LogInReqDTO;
import com.mini.money.dto.myinfo.MyCustomerDetailInfoResDTO;
import com.mini.money.dto.myinfo.UpdateDetailReqDTO;
import com.mini.money.dto.myinfo.UpdateInfoReqDTO;
import com.mini.money.service.AuthService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Api(tags = {"회원 추가정보 서비스"}, description = "회원 추가 정보 입력, 조회")
public class CustomerDetailController {

    private final AuthService authService;

    @PostMapping("/signup/detail")
    @ApiOperation(value = "회원 추가 정보 입력", notes = "회원 추가 정보를 입력 받아 저장을 시도, 성공 시 DB에 저장한다.")
    public ResponseEntity<String> customerDetailInfo(@RequestBody CustomerDetailReqDTO reqDTO, @AuthenticationPrincipal LogInReqDTO customer) {
        String email = customer.getEmail();
        String message = authService.customerDetailInfo(email, reqDTO);

        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @PutMapping("/mypage/member/detail")
    @ApiOperation(value = "회원 상세 정보 수정", notes = "상세 정보 수정이 가능하다.")
    public ResponseEntity<String> updateInfo(@RequestBody UpdateDetailReqDTO detail, @AuthenticationPrincipal LogInReqDTO customer) {
        String email = customer.getEmail();
        String message = authService.updateDetailInfo(detail, email);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }


    @GetMapping("/mypage/detail/info")
    @ApiOperation(value = "회원 정보 조회", notes = "회원 정보를 확인한다.")
    public ResponseEntity<Object> findMyDetailInfo(@AuthenticationPrincipal LogInReqDTO customer) {
        String email = customer.getEmail();
        MyCustomerDetailInfoResDTO my = authService.findMyDetailInfo(email);

        if (my == null) {
            return new ResponseEntity<>("failed", HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(my, HttpStatus.OK);
        }
    }
}
