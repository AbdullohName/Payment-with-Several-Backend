package com.example.easypay.dto;

import com.example.easypay.entity.HistoryPay;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

/**
 * A DTO for the {@link HistoryPay} entity
 */
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class HistoryPayDto {
    private Integer id;
    private String fullName;
    private String cardNumber;
    private Integer paymentNumber;
    private Double pay;
    private Double cashBack;
    private Date date;
    private Integer userId;
}