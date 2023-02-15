package com.mini.money.service.impl;


import com.mini.money.entity.Blacklist;
import com.mini.money.repository.TokenRepository;
import com.mini.money.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TokenServiceImpl implements TokenService{

    private final TokenRepository tokenRepository;


    @Override
    public String logout(String token) {
        if(checkBlacklist(token)){
            return "이미 만료된 토큰입니다. 다시 로그인해주세요.";
        }else{
            try{
                tokenRepository.save(Blacklist.builder().token(token).build());
                return "success";
            }catch (Exception e){
                return "failed";
            }
        }
    }

    @Override
    public boolean checkBlacklist(String token) {
        return tokenRepository.existsByToken(token);
    }
}