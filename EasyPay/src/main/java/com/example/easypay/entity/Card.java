package com.example.easypay.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "card_id_seq")
    private Long id;
    private String name;
    private String number;
    private Integer userId;
}
