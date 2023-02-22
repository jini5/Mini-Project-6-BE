package com.mini.money.service.impl;

import com.mini.money.entity.Blacklist;
import com.mini.money.repository.TokenRepository;
import com.mini.money.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TokenServiceImpl implements TokenService{

    private final TokenRepository tokenRepository;


    @Override
    public ResponseEntity logout(String token) {
        if(checkBlacklist(token)){
            String result = "failed";
            return new ResponseEntity(result, HttpStatus.BAD_REQUEST);
        }else{
            try{
                tokenRepository.save(Blacklist.builder().token(token).build());
                String result = "success";
                return new ResponseEntity(result,HttpStatus.OK);
            }catch (Exception e){
                String result = "failed";
                return new ResponseEntity(result,HttpStatus.BAD_REQUEST);
            }
        }
    }

    @Override
    public boolean checkBlacklist(String token) {
        return tokenRepository.existsByToken(token);
    }
}