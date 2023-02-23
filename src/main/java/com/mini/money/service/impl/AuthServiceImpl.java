package com.mini.money.service.impl;

import com.mini.money.dto.CustomerDetailReqDTO;
import com.mini.money.dto.CustomerReqDTO;
import com.mini.money.dto.LogInReqDTO;
import com.mini.money.dto.LogInResDTO;
import com.mini.money.dto.myinfo.MyCustomerDetailInfoResDTO;
import com.mini.money.dto.myinfo.MyCustomerInfoResDTO;
import com.mini.money.dto.myinfo.UpdateDetailReqDTO;
import com.mini.money.dto.myinfo.UpdateInfoReqDTO;
import com.mini.money.entity.Customer;
import com.mini.money.entity.CustomerDetail;
import com.mini.money.jwt.JwtProvider;
import com.mini.money.repository.CustomerDetailRepository;
import com.mini.money.repository.CustomerRepository;
import com.mini.money.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final CustomerRepository customerRepository;
    private final CustomerDetailRepository customerDetailRepository;
    private final JwtProvider jwtProvider;
    private final PasswordEncoder passwordEncoder;
    public static final String pattern = "^[A-Za-z[0-9]]{8,16}$"; // 영문, 숫자 8~16자리


    @Transactional
    @Override
    public ResponseEntity signup(CustomerReqDTO signupReqDTO) {

        Customer checkCustomer = null;
        try {
            checkCustomer = customerRepository.findByEmail(signupReqDTO.getEmail());
        }catch (Exception e){
        }
        if (checkCustomer!=null){
            String str = signupReqDTO.getEmail() + "는 이미 존재하는 이메일 입니다. 다른 이메일을 사용해주세요";
            System.out.println(str);
            return new ResponseEntity(str,  HttpStatus.BAD_REQUEST);
        }else if(!signupReqDTO.getPassword().matches(pattern)) {
            String str = "비밀번호는 문자,숫자만 사용가능합니다. \n8~16자리로 설정해주세요";
            return new ResponseEntity(str,  HttpStatus.BAD_REQUEST);
        }else{
            String password = encodingPassword(signupReqDTO.getPassword());
            signupReqDTO.setPassword(password);

            Customer customer = signupReqDTO.toEntity();
            customerRepository.save(customer);
            return new ResponseEntity(HttpStatus.OK);
        }

    }

    @Override
    public LogInResDTO login(LogInReqDTO logInReqDTO) {

        if(logInReqDTO.getEmail() == null || logInReqDTO.getPassword()==null){
            return new LogInResDTO("아이디 혹은 비밀번호를 다시 확인해주세요.");
        }else{
            Customer customer = null;
            try {
                customer = customerRepository.findByEmail(logInReqDTO.getEmail());
            }catch (Exception e){
            }
            if(customer ==null || !passwordEncoder.matches(logInReqDTO.getPassword(),customer.getPassword())){
                throw new IllegalArgumentException();
            }

            String token = jwtProvider.makeToken(customer);
            LogInResDTO logInResDTO = new LogInResDTO(customer, token);

            return logInResDTO;

        }

    }

    @Transactional
    @Modifying
    @Override
    public String updateInfo(UpdateInfoReqDTO updateInfoReqDTO, String email) {
        System.out.println(updateInfoReqDTO);
        Customer customer = customerRepository.findByEmail(email);
        String password = updateInfoReqDTO.getPassword();
        String phone = updateInfoReqDTO.getPhone();

        if (password == null || password.isBlank()) {
            password = customer.getPassword();
        }

        if (phone == null || phone.isBlank()) {
            phone = customer.getPhone();
        }

        if (password.length() < 20) {
            password = encodingPassword(password);
        }

        Integer result = customerRepository.updateInfo(password, phone, email);

        if (result > 0) {
            return "success";
        } else {
            return "false";
        }
    }

    @Override
    public Map<String, String> checkPassword(String email, String requestPassword) {
        Customer customer = customerRepository.findByEmail(email);
        Map<String, String> customerData = new HashMap<>();
        if (!passwordEncoder.matches(requestPassword, customer.getPassword())) {
            throw new IllegalArgumentException();
        }
        customerData.put("name", customer.getName());
        return customerData;
    }

    @Override
    public MyCustomerInfoResDTO findMyInfo(String email) {
        Customer customer = customerRepository.findByEmail(email);
        MyCustomerInfoResDTO my = new MyCustomerInfoResDTO(
                customer.getEmail(), customer.getName(), customer.getPhone()
        );
        return my;
    }

    @Override
    public MyCustomerDetailInfoResDTO findMyDetailInfo(String email) {
        try {
            Customer loginCustomer = customerRepository.findByEmail(email);
            CustomerDetail customerDetail = customerDetailRepository.findByCustomer(loginCustomer).orElseThrow(() -> new IllegalStateException("추가 정보 등록 요망"));

            MyCustomerDetailInfoResDTO my = new MyCustomerDetailInfoResDTO(
                    customerDetail.getAge(), customerDetail.getAddress(), customerDetail.getJob(),
                    customerDetail.getBank(), customerDetail.getCrdtGrade(), customerDetail.getIncome()
            );

            return my;
        } catch (IllegalStateException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Transactional
    @Override
    public String customerDetailInfo(String email, CustomerDetailReqDTO reqDTO) {
        Customer loginCustomer = customerRepository.findByEmail(email);
        CustomerDetail customerDetail = reqDTO.toEntity(loginCustomer);
        customerDetailRepository.save(customerDetail);

        return "success";
    }

    @Transactional
    @Modifying
    @Override
    public String updateDetailInfo(UpdateDetailReqDTO detailReqDTO, String email) {
        Customer customer = customerRepository.findByEmail(email);
        CustomerDetail detail = customerDetailRepository.findByCustomer(customer).orElse(null);

        String address = detailReqDTO.getAddress() == null || detailReqDTO.getAddress().isBlank()? detail.getAddress():detailReqDTO.getAddress();
        Integer age = detailReqDTO.getAge() == null? detail.getAge():detailReqDTO.getAge();
        Double crdtGrade = detailReqDTO.getCrdtGrade() == null? detail.getCrdtGrade():detailReqDTO.getCrdtGrade();
        String job = detailReqDTO.getJob() == null || detailReqDTO.getJob().isBlank()? detail.getJob():detailReqDTO.getJob();
        Integer income = detailReqDTO.getIncome() == null? detail.getIncome():detailReqDTO.getIncome();
        String bank = detailReqDTO.getBank() == null || detailReqDTO.getBank().isBlank()? detail.getBank():detailReqDTO.getBank();

        Integer result = customerDetailRepository.updateDetailInfo(
                address,
                age,
                crdtGrade,
                job,
                income,
                bank,
                detail.getId());

        return result > 0? "success":"failed";
    }


    private String encodingPassword(String password) {
        return passwordEncoder.encode(password);
    }

}
