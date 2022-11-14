package com.example.paynet.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WithdrawMoneyDto {
    private String cardNumberTakeOff;
    private Double price;
    private String cardNumberAddMoney;
    private Long transAcId;
}