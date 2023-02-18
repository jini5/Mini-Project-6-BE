package com.mini.money.repository;

import com.mini.money.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.parameters.P;

public interface CustomerRepository extends JpaRepository<Customer, String> {

    Customer findByEmail(String email);

    @Modifying
    @Query(value = "UPDATE customer c SET c.password = :password, c.phone = :phone WHERE c.email = :email", nativeQuery = true)
    Integer updateInfo(@Param("password") String password, @Param("phone") String phone, @Param("email") String email);
}
