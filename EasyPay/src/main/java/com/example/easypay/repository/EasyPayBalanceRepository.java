package com.example.easypay.repository;

import com.example.easypay.entity.EasyPayBalance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EasyPayBalanceRepository extends JpaRepository<EasyPayBalance, Long> {
}