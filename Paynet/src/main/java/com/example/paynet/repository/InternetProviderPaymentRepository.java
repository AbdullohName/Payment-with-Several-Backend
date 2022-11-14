package com.example.paynet.repository;


import com.example.paynet.model.entity.InternetProviderPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InternetProviderPaymentRepository extends JpaRepository<InternetProviderPayment, Long> {
}