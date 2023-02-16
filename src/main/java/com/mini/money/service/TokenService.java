package com.mini.money.service;

public interface TokenService {

    String logout(String header);

    boolean checkBlacklist(String token);

}
