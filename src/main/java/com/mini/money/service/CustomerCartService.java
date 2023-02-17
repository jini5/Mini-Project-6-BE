package com.mini.money.service;

import com.mini.money.dto.myinfo.MyCustomerCartResDTO;
import com.mini.money.entity.Customer;

import java.util.List;

public interface CustomerCartService {
    List<MyCustomerCartResDTO> selectCartList(Customer customer);

}
