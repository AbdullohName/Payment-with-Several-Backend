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
public class CardTransfer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "card_transfer_seq")
    private Long id;
    private String cardNumberToTakeOff;
    private Double price;
    private String cardNumberToTopUp;
    private Long userId;
    private Boolean success = false;
}
