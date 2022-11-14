package com.example.easypay.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class EasyPayBalance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "easy_balance_id_seq")
    private Long id;
    private String cardNumber;
    private String phoneNumber;
}
