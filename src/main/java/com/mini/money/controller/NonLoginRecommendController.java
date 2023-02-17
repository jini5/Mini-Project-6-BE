package com.mini.money.controller;

import com.mini.money.dto.NonLoginRecommendResDTO;
import com.mini.money.service.impl.NonLoginRecommendServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class NonLoginRecommendController {

    private final NonLoginRecommendServiceImpl service;

    @GetMapping("/finance/recommend/loan")
    public List<NonLoginRecommendResDTO> selectRecommendList(){
        return service.selectRecommendList();
    }
}
