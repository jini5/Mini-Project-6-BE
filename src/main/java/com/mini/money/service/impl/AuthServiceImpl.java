package com.mini.money.service.impl;

import com.mini.money.dto.CustomerReqDTO;
import com.mini.money.entity.Customer;
import com.mini.money.jwt.JwtProvider;
import com.mini.money.repository.CustomerRepository;
import com.mini.money.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final CustomerRepository customerRepository;
    private final JwtProvider jwtProvider;
    private final PasswordEncoder passwordEncoder;
    public static final String pattern = "^[A-Za-z[0-9]]{8,12}$"; // 영문, 숫자 8~12자리


    @Override
    public String signup(CustomerReqDTO signupReqDTO) {

        Customer checkCustomer = null;
        try {
            checkCustomer = customerRepository.findByEmail(signupReqDTO.getEmail());
        }catch (Exception e){
        }
        if (checkCustomer!=null){
            return signupReqDTO.getEmail() + "는 이미 존재하는 이메일 입니다. \n다른 이메일을 사용해주세요";
        }else if(!signupReqDTO.getPassword().matches(pattern)) {
            return "비밀번호는 문자,숫자만 사용가능합니다. \n8~12자리로 설정해주세요";
        }else{
            String password = encodingPassword(signupReqDTO.getPassword());
            signupReqDTO.setPassword(password);

            Customer customer = signupReqDTO.toEntity();

            System.out.println(customer.toString());

            customer =customerRepository.save(customer);
            System.out.println(customer.toString());
            return "success";
        }

    }

    private String encodingPassword(String password) {
        return passwordEncoder.encode(password);
    }

}
