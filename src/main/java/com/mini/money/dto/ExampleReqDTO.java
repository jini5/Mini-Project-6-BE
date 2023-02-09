//package com.mini.money.dto;
//
//import lombok.*;
//
//import java.util.Collection;
//import java.util.Collections;
//
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//@ToString
//public class ExampleReqDTO {
//    private String userId;
//    private String userPw;
//    private String role;
//
//    public LoginRequest(Claims claims) {
//        this.userId = claims.get("id", String.class);
//    }
//
//    public Account toEntity() {
//        return Account.builder()
//                .userId(userId)
//                .userPw(userPw)
//                .role(role)
//                .build();
//    }
//
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"));
//    }
//}
