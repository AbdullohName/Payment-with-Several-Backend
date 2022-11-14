package com.example.paynet.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PhoneNumberPayment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "history_id_seq")
    private Long id;
    private String phoneNumber;
    private Double price;
    private String providerName;
    private String cardNumber;
    private Long userId;
    private String serviceCardNumber;
    private Long transAcId;
}
