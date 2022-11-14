package com.example.paynet.model.dto;

import com.example.paynet.model.entity.CardTransfer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A DTO for the {@link CardTransfer} entity
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CardTransferDto {
    private Long id;
    private String cardNumberToTakeOff;
    private Double price;
    private String cardNumberToTopUp;
    private Long userId;
}