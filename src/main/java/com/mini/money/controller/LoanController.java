package com.mini.money.controller;


import com.mini.money.dto.LoanResDTO;
import com.mini.money.dto.LogInReqDTO;
import com.mini.money.dto.itemlist.CommendResDTO;
import com.mini.money.dto.itemlist.WholeResDTO;
import com.mini.money.parameter.*;
import com.mini.money.service.FavorService;
import com.mini.money.service.LoanService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Api(tags = {"상품 서비스"}, description = "전체 상품 조회, 항목 별 상품 조회, 상품 추천")
public class LoanController {

    private final LoanService service;
    private final FavorService favorService;

    @GetMapping("/finance/loan")
    public List<LoanResDTO> selectLoanList() {
        return service.selectLoanList();
    }

    @GetMapping("/finance/itemlist")
    public List<WholeResDTO> allSelectList(Pageable pageable) {
        return service.selectAll(pageable);
    }

    @GetMapping("/finance/itemlist/office")
    public Page<WholeResDTO> selectByOffice(@RequestParam(name = "office") Office office, Pageable pageable) {
        return service.selectByOffice(office, pageable);
    }

    @GetMapping("/finance/itemlist/area")
    public Page<WholeResDTO> selectByArea(@RequestParam(name = "area") Area area, Pageable pageable) {
        return service.selectByArea(area, pageable);
    }

    @GetMapping("/finance/itemlist/repayment")
    public Page<WholeResDTO> selectByRepayment(@RequestParam(name = "repayment") Repayment repayment, Pageable pageable) {
        return service.selectByRepayment(repayment, pageable);
    }

    @GetMapping("/finance/itemlist/usge")
    public Page<WholeResDTO> selectByUsge(@RequestParam(name = "usge") Usge usge, Pageable pageable) {
        return service.selectByUsge(usge, pageable);
    }

    @GetMapping("/finance/itemlist/target")
    public Page<WholeResDTO> selectByTarget(@RequestParam(name = "target") Target target, Pageable pageable) {
        return service.selectByTarget(target, pageable);
    }

    @GetMapping("/finance/itemlist/baseRate")
    public Page<WholeResDTO> selectByBaseRate(@RequestParam(name = "baseRate") BaseRate baseRate, Pageable pageable) {
        return service.selectByBaseRate(baseRate, pageable);
    }

    @GetMapping("/finance/itemlist/maturity")
    public Page<WholeResDTO> selectByMaturity(@RequestParam(name = "maturity") String maturity, Pageable pageable) {
        return service.selectByMaturity(maturity, pageable);
    }

    @GetMapping("/finance/itemlist/credit")
    public Page<WholeResDTO> selectByCredit(@RequestParam(name = "credit") String credit, Pageable pageable) {
        return service.selectByCredit(credit, pageable);
    }

    @GetMapping("/finance/itemlist/keyword")
    public Page<WholeResDTO> selectByKeyword(@RequestParam(name = "keyword") String keyword, Pageable pageable) {
        return service.selectByKeyword(keyword, pageable);
    }

    @GetMapping("/finance/loan/detail")
    @ApiOperation(value = "상품 상세 정보 반환", notes = "상품 상세 정보를 반환")
    public HashMap<String, Object> selectLoanDetail(@RequestParam(name = "snq") Long snq) {
        return service.selectLoanDetail(snq);
    }

    @GetMapping("/finance/member/recommend/loan")
    @ApiOperation(value = "(로그인 상태)상품 추천 리스트 반환", notes = "사용자 지역의 상품 리스트를 반환, 설정한 지역이 없다면 전국")
    public Page<CommendResDTO> memberRecommendList(@AuthenticationPrincipal LogInReqDTO logInReqDTO) {
        return service.memberCommendLoanList(logInReqDTO);
    }

    @GetMapping("/finance/recommend/loan")
    public Page<WholeResDTO> recommendDatas() {
        return favorService.popularList();
    }
}
