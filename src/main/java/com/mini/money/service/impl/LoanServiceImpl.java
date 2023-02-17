package com.mini.money.service.impl;

import com.mini.money.dto.LoanResDTO;
import com.mini.money.dto.LogInReqDTO;
import com.mini.money.dto.itemlist.CommendResDTO;
import com.mini.money.dto.itemlist.WholeResDTO;
import com.mini.money.dto.loan.LoanEtcResDTO;
import com.mini.money.dto.loan.LoanProdInfoResDTO;
import com.mini.money.dto.loan.LoanTargetResDTO;
import com.mini.money.entity.Customer;
import com.mini.money.entity.CustomerDetail;
import com.mini.money.entity.Loan;
import com.mini.money.parameter.*;
import com.mini.money.repository.CustomerDetailRepository;
import com.mini.money.repository.CustomerRepository;
import com.mini.money.repository.LoanRepository;
import com.mini.money.service.LoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LoanServiceImpl implements LoanService {

    private final LoanRepository repository;
    private final CustomerDetailRepository customerDetailRepository;
    private final CustomerRepository customerRepository;

    @Override
    public List<LoanResDTO> selectLoanList() {
        List<LoanResDTO> list =  repository.findAll()
                .stream()
                .map(res -> new LoanResDTO(Loan.builder()
                        .snq(res.getSnq())
                        .loanName(res.getLoanName())
                        .loanDescription(res.getLoanDescription())
                        .loanTarget(res.getLoanTarget())
                        .baseRate(res.getBaseRate())
                        .rate(res.getRate())
                        .build()))
                .collect(Collectors.toList());
        List<LoanResDTO> loanList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            int num = (int) (Math.random() * list.size()) + 1;
            loanList.add(list.get(num));
        }
        return loanList;
    }

    @Override
    public List<WholeResDTO> selectAll(Pageable pageable) {
        Page<Loan> selectAll = repository.findAll(pageable);
        List<WholeResDTO> wholeList = new ArrayList<>();
        for (int i = 0; i < selectAll.getSize(); i++) {
            Loan loan = selectAll.getContent().get(i);
            String[] targetList = loan.getLoanTarget().split(",");
            WholeResDTO wholeResDTO = new WholeResDTO(loan.getSnq(), loan.getLoanName(),
                    loan.getLoanLimit(), loan.getProvider(), targetList, loan.getRate());

            wholeList.add(wholeResDTO);
        }
        return wholeList;
    }

    @Override
    public List<WholeResDTO> selectByOffice(Office office, Pageable pageable) {
        Office[] os = Office.values();
        List<String> officeList = Arrays.stream(os).map(Objects::toString).collect(Collectors.toList());
        officeList.remove("기타");

        List<Loan> selectAllByOffice;

        if (office.name().equals("기타")) {
            selectAllByOffice = repository.findAllByDivisionOfficeNotIn(officeList, pageable);
        } else {
            selectAllByOffice = repository.findAllByDivisionOfficeContaining(office.name(), pageable);
        }

        return getWholeResDTOS(selectAllByOffice);
    }

    @Override
    public List<WholeResDTO> selectByArea(Area area, Pageable pageable) {
        Area[] ar = Area.values();
        List<String> areaList = Arrays.stream(ar).map(Objects::toString).collect(Collectors.toList());
        areaList.remove("기타");

        List<Loan> selectAllByArea;

        if (area.name().equals("기타")) {
            selectAllByArea = repository.findAllByAreaNotIn(areaList, pageable);
        } else {
            selectAllByArea = repository.findAllByAreaContaining(area.name(), pageable);
        }

        return getWholeResDTOS(selectAllByArea);
    }

    @Override
    public List<WholeResDTO> selectByRepayment(Repayment repayment, Pageable pageable) {
        Repayment[] rm = Repayment.values();
        List<String> repayList = Arrays.stream(rm).map(Objects::toString).collect(Collectors.toList());
        repayList.remove("기타");

        List<Loan> selectAllByRepayment;

        if (repayment.name().equals("기타")) {
            selectAllByRepayment = repository.findAllByRepayMethodNotIn(repayList, pageable);
        } else {
            selectAllByRepayment = repository.findAllByRepayMethodContaining(repayment.name(), pageable);
        }

        return getWholeResDTOS(selectAllByRepayment);
    }

    @Override
    public List<WholeResDTO> selectByUsge(Usge usge, Pageable pageable) {
        Usge[] us = Usge.values();
        List<String> usgeList = Arrays.stream(us).map(Objects::toString).collect(Collectors.toList());
        usgeList.remove("기타");

        List<Loan> selectAllByUsge;

        if (usge.name().equals("기타")) {
            selectAllByUsge = repository.findAllByUsgeNotIn(usgeList, pageable);
        } else {
            selectAllByUsge = repository.findAllByUsgeContaining(usge.name(), pageable);
        }

        return getWholeResDTOS(selectAllByUsge);
    }

    @Override
    public List<WholeResDTO> selectByTarget(Target target, Pageable pageable) {
        Target[] tr = Target.values();
        List<String> targetList = Arrays.stream(tr).map(Objects::toString).collect(Collectors.toList());
        targetList.remove("기타");

        List<Loan> selectAllByTarget;

        if (target.name().equals("기타")) {
            selectAllByTarget = repository.findAllByLoanTargetNotIn(targetList, pageable);
        } else {
            selectAllByTarget = repository.findAllByLoanTargetContaining(target.name(), pageable);
        }

        return getWholeResDTOS(selectAllByTarget);
    }

    @Override
    public List<WholeResDTO> selectByBaseRate(BaseRate baseRate, Pageable pageable) {
        BaseRate[] br = BaseRate.values();
        List<String> baseRateList = Arrays.stream(br).map(Objects::toString).collect(Collectors.toList());
        baseRateList.remove("기타");

        List<Loan> selectAllByBaseRate;

        if (baseRate.name().equals("기타")) {
            selectAllByBaseRate = repository.findAllByBaseRateNotIn(baseRateList, pageable);
        } else {
            selectAllByBaseRate = repository.findAllByBaseRateContaining(baseRate.name(), pageable);
        }

        return getWholeResDTOS(selectAllByBaseRate);
    }

    @Override
    public List<WholeResDTO> selectByMaturity(String maturity, Pageable pageable) {
        List<Loan> selectAllByMaturity;

        String filter = "상시";

        if (maturity.equals("상시")) {
            selectAllByMaturity = repository.findAllByMaturityContaining(filter, pageable);
        } else {
            selectAllByMaturity = repository.findAllByMaturityNotContaining(filter, pageable);
        }

        return getWholeResDTOS(selectAllByMaturity);
    }

    @Override
    public List<WholeResDTO> selectByCredit(String credit, Pageable pageable) {
        List<Loan> selectAllByCredit;

        String filter = "없음";

        if (credit.equals("N")) {
            selectAllByCredit = repository.findAllByCreditScoreContaining(filter, pageable);
        } else {
            selectAllByCredit = repository.findAllByCreditScoreNotContaining(filter, pageable);
        }

        return getWholeResDTOS(selectAllByCredit);
    }

    @Override
    public List<WholeResDTO> selectByKeyword(String keyword, Pageable pageable) {
        List<Loan> selectAllByKeyword = repository.findAllByLoanNameContaining(keyword, pageable);

        return getWholeResDTOS(selectAllByKeyword);
    }

    @Override
    public HashMap<String, Object> selectLoanDetail(Long snq) {
        Loan loan = repository.findBySnq(snq).orElse(null);

        HashMap<String, Object> loanDetail = new HashMap<>();

        LoanProdInfoResDTO prodInfo = new LoanProdInfoResDTO(loan);
        LoanTargetResDTO targetInfo = new LoanTargetResDTO(loan);
        LoanEtcResDTO etcInfo = new LoanEtcResDTO(loan);

        loanDetail.put("loan", prodInfo);
        loanDetail.put("target", targetInfo);
        loanDetail.put("etc", etcInfo);

        return loanDetail;
    }

    @Override
    public List<CommendResDTO> memberCommendLoanList(LogInReqDTO logInReqDTO) {
        Customer customer = customerRepository.findByEmail(logInReqDTO.getEmail());
        String area = "전국";
        Optional<CustomerDetail> customerDetail = customerDetailRepository.findByCustomer(customer);
        if(!customerDetail.isEmpty()) {
            if(customerDetail.get().getAddress() !=null){
                area = customerDetail.get().getAddress();
            }
        }
        List<Loan> CommendByArea =  repository.findAllByAreaContaining(area);

        return getCommenResDTOS(CommendByArea);
    }


    private List<WholeResDTO> getWholeResDTOS(List<Loan> selectAllByArea) {
        List<WholeResDTO> wholeList = new ArrayList<>();

        for (int i = 0; i < selectAllByArea.size(); i++) {
            Loan loan = selectAllByArea.get(i);
            String[] targetList = loan.getLoanTarget().split(",");

            WholeResDTO wholeResDTO = new WholeResDTO(loan.getSnq(), loan.getLoanName(),
                    loan.getLoanLimit(), loan.getProvider(), targetList, loan.getRate());

            wholeList.add(wholeResDTO);
        }
        return wholeList;
    }

    private List<CommendResDTO> getCommenResDTOS(List<Loan> CommendByArea) {
        List<CommendResDTO> commendList = new ArrayList<>();

        for (int i = 0; i < CommendByArea.size(); i++) {
            Loan loan = CommendByArea.get(i);
            String[] targetList = loan.getLoanTarget().split(",");

            CommendResDTO commendResDTO = new CommendResDTO(loan.getSnq(), loan.getLoanName(),
                    loan.getLoanLimit(), loan.getProvider(), targetList, loan.getArea(), loan.getRate());

            commendList.add(commendResDTO);
        }
        return commendList;
    }

}
