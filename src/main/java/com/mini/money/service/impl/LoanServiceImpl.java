package com.mini.money.service.impl;

import com.mini.money.dto.LoanResDTO;
import com.mini.money.dto.itemlist.WholeResDTO;
import com.mini.money.entity.Loan;
import com.mini.money.parameter.Office;
import com.mini.money.repository.LoanRepository;
import com.mini.money.service.LoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LoanServiceImpl implements LoanService {

    private final LoanRepository repository;

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
            WholeResDTO wholeResDTO = new WholeResDTO(loan.getSnq(), loan.getLoanName(),
                    loan.getLoanDescription(), loan.getLoanTarget(), loan.getBaseRate(), loan.getRate());

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
            System.out.println("1");
        } else {
            selectAllByOffice = repository.findAllByDivisionOfficeContaining(office.name(), pageable);
            System.out.println("2");
        }

        List<WholeResDTO> wholeList = new ArrayList<>();

        for (int i = 0; i < selectAllByOffice.size(); i++) {
            Loan loan = selectAllByOffice.get(i);

            WholeResDTO wholeResDTO = new WholeResDTO(loan.getSnq(), loan.getLoanName(),
                    loan.getLoanDescription(), loan.getLoanTarget(), loan.getBaseRate(), loan.getRate()
            );
            wholeList.add(wholeResDTO);
        }
        return wholeList;
    }
}
