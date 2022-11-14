package com.example.paynet.repository;

import com.example.paynet.model.entity.CardTransfer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardTransferRepository extends JpaRepository<CardTransfer, Long> {
}