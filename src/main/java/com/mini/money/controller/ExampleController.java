//package com.mini.money.controller;
//
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//@Slf4j
//@RequiredArgsConstructor
//@RestController
//public class ExampleController {
//    private final LoginService ls;
//
//    @PostMapping("/signup")
//    public ResponseEntity<String> signup(@RequestBody @Valid SignupRequest req, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            String message = "form";
//            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
//        }
//
//        String message = ls.signup(req);
//
//        if (message.equals("success")) {
//            return new ResponseEntity<>(message, HttpStatus.OK);
//        } else if (message.equals("failed")) {
//            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
//        }
//        return null;
//    }
//
//    @PostMapping("/login")
//    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest req) {
//        log.info("{}", req);
//        LoginResponse res = ls.login(req);
//
//        log.info("{}", res);
//        return new ResponseEntity<>(res, HttpStatus.OK);
//    }
//}
