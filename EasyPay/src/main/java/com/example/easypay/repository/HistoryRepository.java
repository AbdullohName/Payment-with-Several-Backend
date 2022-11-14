package com.example.easypay.repository;


import com.example.easypay.entity.HistoryPay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface HistoryRepository extends JpaRepository<HistoryPay, Long> {
    Optional<HistoryPay> findByPaymentNumberAndPaymentSuccess(Long PaymentNumber,Boolean success);
    List<HistoryPay> getHistoryPayById(Long id);
}