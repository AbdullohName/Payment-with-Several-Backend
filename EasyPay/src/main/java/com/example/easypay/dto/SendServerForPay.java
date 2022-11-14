package com.example.easypay.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

//Paynet uchun, tolovni amalga oshirish
@NoArgsConstructor @AllArgsConstructor @Builder
@JsonIgnoreProperties(value = {"easyPayCartNumber"},allowGetters = true)
public class SendServerForPay {
    @Size(min = 13,max = 13)
    private String phoneNumber;
    @Min(value = 0)
    private Double price;
    private String providerName;
    @Size(min = 19,max = 19)
    private String cardNumber;
    private String serviceCardNumber = "8600 4444 4444 4444";
    private Long userId;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getServiceCardNumber() {
        return serviceCardNumber;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
