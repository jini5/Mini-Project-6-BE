//package com.mini.money.service;
//
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Service;
//
//@Slf4j
//@Service
//@RequiredArgsConstructor
//public class ExampleService {
//    private final LoginRepository lr;
//    private final PasswordEncoder passwordEncoder;
//    private final JwtTokenProvider jwtTokenProvider;
//
//    public String signup(SignupRequest req) {
//        if (lr.findByUserId(req.getUserId()).orElse(null) != null) { // 회원 테이블을 userId 기준으로 select 해서 나온 값이 있으면 "failed"
//            return "failed";
//        }
//
//
//        String encodingPassword = encodingPassword(req.getUserPw());
//        req.setUserPw(encodingPassword);
//        lr.save(req.toEntity());
//        return "success";
//    }
//
//    public LoginResponse login(LoginRequest req) {
//        Account acc = req.toEntity();
//        Account result = lr.findByUserId(acc.getUserId()).orElse(null);
//        if (result != null) {
//            try {
//                passwordMustBeSame(req.getUserPw(), result.getUserPw());
//            } catch (IllegalArgumentException e) {
//                e.printStackTrace();
//                return null;
//            }
//            String token = jwtTokenProvider.makeJwtToken(req);
//            return new LoginResponse(result, token);
//        }
//        return null;
//    }
//
//    private void passwordMustBeSame(String reqPw, String pw) {
//        if (!passwordEncoder.matches(reqPw, pw)) {
//            throw new IllegalArgumentException();
//        }
//    }
//
//    private String encodingPassword(String pw) {
//        return passwordEncoder.encode(pw);
//    }
//}
