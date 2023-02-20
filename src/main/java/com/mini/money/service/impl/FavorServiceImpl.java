package com.mini.money.service.impl;

import com.mini.money.dto.LoanResDTO;
import com.mini.money.dto.favor.FavorReqDTO;
import com.mini.money.dto.itemlist.WholeResDTO;
import com.mini.money.entity.Customer;
import com.mini.money.entity.Favor;
import com.mini.money.entity.Loan;
import com.mini.money.repository.CustomerRepository;
import com.mini.money.repository.FavorRepository;
import com.mini.money.repository.LoanRepository;
import com.mini.money.service.FavorService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FavorServiceImpl implements FavorService {

    private final FavorRepository favorRepo;

    private final CustomerRepository customerRepo;

    private final LoanRepository loanRepo;



    @Override
    public String addFavor(String email, Long snq) {
        Customer customer = customerRepo.findByEmail(email);
        Loan loan = loanRepo.findBySnq(snq).orElse(null);
        try {
            favorRepo.save(new FavorReqDTO().toEntity(customer, loan));
        }catch (Exception err) {
            err.printStackTrace();
            return "failed";
        }
        return "success";


    }
    @Transactional
    @Override
    public String deleteFavor(String email, Long snq) {
        try {
            Customer customer = customerRepo.findByEmail(email);
            Loan loan = loanRepo.findBySnq(snq).orElse(null);
            favorRepo.deleteByCustomerAndLoan(customer, loan);
        }catch (Exception err) {
            err.printStackTrace();
            return "failed";
        }
        return "success";
    }

    @Override
    public List<LoanResDTO> selectFavorList(String email) {
        Customer customer = customerRepo.findByEmail(email);
        List<Favor> testss = favorRepo.findAllByCustomer(customer);
        List<LoanResDTO> list = new ArrayList<>();
        for (int i = 0; i < testss.size(); i++) {
            Loan loan = testss.get(i).getLoan();

            LoanResDTO loanResDTO = new LoanResDTO(
                    loan.getSnq(),
                    loan.getLoanName(),
                    loan.getRate(),
                    loan.getProvider(),
                    loan.getLoanLimit(),
                    loan.getLoanTarget()
            );
            list.add(loanResDTO);
        }
        return list;
    }

    @Override
    public Page<WholeResDTO> popularList() {
        PageRequest page = PageRequest.of(0, 10);
        Page<Loan> popularData = favorRepo.findPopularData(page);
        Page<WholeResDTO> map = popularData.map(loan -> new WholeResDTO(loan));

        return map;
    }
}
