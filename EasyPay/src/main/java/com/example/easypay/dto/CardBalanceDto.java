package com.example.easypay.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data @Builder @AllArgsConstructor @NoArgsConstructor
public class CardBalanceDto {
    private String fullName;
    private Date validThru;
    private Double balance;
    private String cardNumber;
    private String phoneNumber;
    private String bankName;
}
