package com.mini.money.service.impl;

import com.mini.money.dto.LoanResDTO;
import com.mini.money.dto.cart.CartReqDTO;
import com.mini.money.entity.Cart;
import com.mini.money.entity.Customer;
import com.mini.money.entity.Loan;
import com.mini.money.repository.CartRepository;
import com.mini.money.repository.CustomerRepository;
import com.mini.money.repository.LoanRepository;
import com.mini.money.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepo;
    private final CustomerRepository customerRepo;
    private final LoanRepository loanRepo;


    @Override
    public String addCart(Long snq, String email) {
        Loan loan = loanRepo.findBySnq(snq).orElse(null);
        Customer customer = customerRepo.findByEmail(email);
        try {
            if (!cartRepo.existsByCustomerAndLoan(customer, loan)) {
                deleteLastCart(snq, email);
                cartRepo.save(new CartReqDTO().toEntity(customer, loan));
            } else {
                return "failed";
            }
        } catch (Exception err) {
            err.printStackTrace();
            return "failed";
        }
        return "success";
    }

    @Transactional
    @Override
    public String deleteProduct(String email, Long snq) {
        try {
            Customer customer = customerRepo.findByEmail(email);
            Loan loan = loanRepo.findBySnq(snq).orElse(null);
            cartRepo.deleteByCustomerAndLoan(customer, loan);
        } catch (Exception err) {
            err.printStackTrace();
            return "failed";
        }
        return "success";
    }

    @Override
    public List<LoanResDTO> selectCartList(String email) {
        Customer customer = customerRepo.findByEmail(email);
        List<Cart> carts = cartRepo.findAllByCustomer(customer);
        List<LoanResDTO> list = new ArrayList<>();
        for (int i = 0; i < carts.size(); i++) {
            Loan loan = carts.get(i).getLoan();

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

    //가장 마지막에 추가한 상품 제거 (10개 이상 시)
    @Override
    public void deleteLastCart(Long snq, String email) {
        Customer customer = customerRepo.findByEmail(email);
        List<Cart> carts = cartRepo.findAllByCustomer(customer);
        Cart cart = cartRepo.findFirstByCustomerOrderByIdAsc(customer);

        if (carts.size() >= 10) {
            cartRepo.deleteById(cart.getId());
        }
    }
}