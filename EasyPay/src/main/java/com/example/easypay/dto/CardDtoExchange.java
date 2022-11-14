package com.example.easypay.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
// Uzcarddigi malumotlarni qaytayotganda ushlab oliw uchun
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class CardDtoExchange {
    private Integer id;
    private String fullName;
    private Date validThru;
    private String phoneNumber;
    private Double balance;
    private String passportId;
    private String cardNumber;
    private Integer pinCode;
    private Boolean sms; //= false;
    private String bankName;
}
