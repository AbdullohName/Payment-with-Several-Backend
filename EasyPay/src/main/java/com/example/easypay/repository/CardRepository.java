package com.example.easypay.repository;

import com.example.easypay.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
    void deleteByNumber(String number);
    Optional<Card> findByNumber(String cardNumber);
}