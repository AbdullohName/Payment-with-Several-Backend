package com.example.easypay.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;
import java.util.List;
// Uzcard yoki Humodan malumotlarni balance biliw uchun malumotlarni tortib keliw
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class RequestDtoForBalance {
    @Size(min = 13,max = 13,message = "PhoneNumber Length Must be 13")
    private String phoneNumber;
    private List<String> cardNumber;
}
