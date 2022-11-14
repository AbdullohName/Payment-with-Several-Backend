package com.example.easypay.dto;

import com.example.easypay.entity.Card;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * A DTO for the {@link Card} entity
 * Uzcard yoki Humo bilan malumot almawiw uchun yuboriladi
 */
@Data @NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(value = {"id"})
public class CardDto {
    private Long id;
    @NotBlank(message = "Is Empty")
    private String name;
    @Size(min = 19,max = 19,message = "Maximum and minimum cardNumber length = 19")
    private String number;
    @NotNull
    private Long userId;
}