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
            return null;
        }else{
            try{
                tokenRepository.save(Blacklist.builder().token(token).build());
                return "success";
            }catch (Exception e){
                return null;
            }
        }
    }

    @Override
    public boolean checkBlacklist(String token) {
        return tokenRepository.existsByToken(token);
    }
}