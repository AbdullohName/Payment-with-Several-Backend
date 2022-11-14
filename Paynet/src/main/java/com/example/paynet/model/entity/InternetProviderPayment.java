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
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InternetProviderPayment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "provider_id_seq")
    private Long id;
    private String providerName;
    private String accountNumber;
    private Double price;
    private String cardNumber;
    private Long userId;
}
