package com.mini.money.service;

import com.mini.money.dto.NonLoginRecommendResDTO;

import java.util.List;

public interface NonLoginRecommendService {

    List<NonLoginRecommendResDTO> selectRecommendList();
}
