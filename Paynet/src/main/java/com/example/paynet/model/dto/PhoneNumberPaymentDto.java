package com.example.paynet.model.dto;


import com.example.paynet.model.entity.PhoneNumberPayment;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

/**
 * A DTO for the {@link PhoneNumberPayment} entity
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(value = {"id","providerName","cardNumber","userId","serviceCardNumber"},allowSetters = true)
public class PhoneNumberPaymentDto {
    private Long id;
    @Size(min = 13,max = 13)
    private String phoneNumber;
    @Min(value = 0)
    private Double price;
    private String providerName;
    @Size(min = 19,max = 19)
    private Long transAcId;
    private String cardNumber;
    private String serviceCardNumber;
    private Long userId;

}
//    private String phoneNumber;
//    private Double price;
//    private String providerName;
//    private String cardNumber;
//    private String easyPayCartNumber = "8600 4444 4444 4444";
//    private Long userId;