package com.mini.money.service;

import com.mini.money.dto.CustomerDetailReqDTO;
import com.mini.money.dto.myinfo.MyCustomerDetailInfoResDTO;
import com.mini.money.entity.Customer;
import com.mini.money.entity.CustomerDetail;
import com.mini.money.repository.CustomerDetailRepository;
import com.mini.money.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerDetailService {

    private final CustomerDetailRepository customerDetailRepository;
    private final CustomerRepository customerRepository;

    public String customerDetailInfo(String email, CustomerDetailReqDTO reqDTO) {
        Customer loginCustomer = customerRepository.findByEmail(email);
        CustomerDetail customerDetail = reqDTO.toEntity(loginCustomer);
        customerDetailRepository.save(customerDetail);

        return "success";
    }

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
}
