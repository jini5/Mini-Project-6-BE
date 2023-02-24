package com.mini.money.repository;

import com.mini.money.entity.Customer;
import com.mini.money.entity.CustomerDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CustomerDetailRepository extends JpaRepository<CustomerDetail, Long> {

    Optional<CustomerDetail> findByCustomer(Customer customer);


    @Modifying
    @Query(value = "UPDATE customer_detail c SET c.address = :address, c.age = :age, c.crdt_Grade = :crdtGrade, c.job = :job, c.income = :income, c.bank = :bank WHERE c.detail_id = :id", nativeQuery = true)
    Integer updateDetailInfo(@Param("address") String address, @Param("age") Integer age, @Param("crdtGrade") Double crdtGrade, @Param("job") String job, @Param("income")String income, @Param("bank") String bank, @Param("id") Long id);
}
