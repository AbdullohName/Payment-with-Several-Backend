package com.example.paynet.repository;


import com.example.paynet.model.entity.PhoneNumberPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneNumberPaymentRepository extends JpaRepository<PhoneNumberPayment, Long> {
    @Query("select count(p) from PhoneNumberPayment p")
    Long countPhoneNumberPaymentBy();
}