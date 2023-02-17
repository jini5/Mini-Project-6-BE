package com.mini.money.repository;

import com.mini.money.entity.Favor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerFavorRepository extends JpaRepository<Favor, String> {

    Optional<Favor> findByEmail(String email);
}
