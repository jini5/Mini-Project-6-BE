package com.mini.money.controller;


import com.mini.money.dto.LoanResDTO;
import com.mini.money.dto.LogInReqDTO;
import com.mini.money.dto.itemlist.CommendResDTO;
import com.mini.money.dto.itemlist.WholeResDTO;
import com.mini.money.parameter.*;
import com.mini.money.service.LoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LoanController {

    private final LoanService service;

    @GetMapping("/finance/loan")
    public List<LoanResDTO> selectLoanList() {
        return service.selectLoanList();
    }

    @GetMapping("/finance/itemlist")
    public List<WholeResDTO> allSelectList(Pageable pageable) {
        return service.selectAll(pageable);
    }

    @GetMapping("/finance/itemlist/office")
    public List<WholeResDTO> selectByOffice(@RequestParam(name = "office") Office office, Pageable pageable) {
        return service.selectByOffice(office, pageable);
    }

    @GetMapping("/finance/itemlist/area")
    public List<WholeResDTO> selectByArea(@RequestParam(name = "area") Area area, Pageable pageable) {
        return service.selectByArea(area, pageable);
    }

    @GetMapping("/finance/itemlist/repayment")
    public List<WholeResDTO> selectByRepayment(@RequestParam(name = "repayment") Repayment repayment, Pageable pageable) {
        return service.selectByRepayment(repayment, pageable);
    }

    @GetMapping("/finance/itemlist/usge")
    public List<WholeResDTO> selectByUsge(@RequestParam(name = "usge") Usge usge, Pageable pageable) {
        return service.selectByUsge(usge, pageable);
    }

    @GetMapping("/finance/itemlist/target")
    public List<WholeResDTO> selectByTarget(@RequestParam(name = "target") Target target, Pageable pageable) {
        return service.selectByTarget(target, pageable);
    }

    @GetMapping("/finance/itemlist/baseRate")
    public List<WholeResDTO> selectByBaseRate(@RequestParam(name = "baseRate") BaseRate baseRate, Pageable pageable) {
        return service.selectByBaseRate(baseRate, pageable);
    }

    @GetMapping("/finance/itemlist/maturity")
    public List<WholeResDTO> selectByMaturity(@RequestParam(name = "maturity") String maturity, Pageable pageable) {
        return service.selectByMaturity(maturity, pageable);
    }

    @GetMapping("/finance/itemlist/credit")
    public List<WholeResDTO> selectByCredit(@RequestParam(name = "credit") String credit, Pageable pageable) {
        return service.selectByCredit(credit, pageable);
    }

    @GetMapping("/finance/itemlist/keyword")
    public List<WholeResDTO> selectByKeyword(@RequestParam(name = "keyword") String keyword, Pageable pageable) {
        return service.selectByKeyword(keyword, pageable);
    }

    @GetMapping("/finance/member/recommend/loan")
    public List<CommendResDTO> memberRecommendList(@AuthenticationPrincipal LogInReqDTO logInReqDTO) {
        return service.memberCommendLoanList(logInReqDTO);
    }
}
