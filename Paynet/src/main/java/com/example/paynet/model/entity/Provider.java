package com.example.paynet.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity @Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Provider {
    @Id
    private Long id;
    private String name;
    private String uzCardNumber;
    private String humoCardNumber;
}
