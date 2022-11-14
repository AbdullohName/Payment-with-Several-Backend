package com.example.paynet.model.dto;


import com.example.paynet.model.entity.InternetProviderPayment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * A DTO for the {@link InternetProviderPayment} entity
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InternetProviderPaymentDto {
    private Long id;
    private String providerName;
    private String accountNumber;
    private Double price;
    private String cardNumber;
    private String easyPayCartNumber;
    private Long userId;
}