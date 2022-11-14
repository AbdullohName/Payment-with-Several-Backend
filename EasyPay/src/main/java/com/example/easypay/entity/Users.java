package com.example.easypay.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity @AllArgsConstructor @NoArgsConstructor @Data
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "Client_id_seq")
    private Long id;
    private String firstName;
    private String lastName;
    @Column(columnDefinition = "unique")
    private String username;
    private String phoneNumber;
    private String password;
    private String email;
    private Double cashBack;
    private String locale;
    @OneToMany(mappedBy = "userId")
    private List<Card> cardList;
    @OneToMany(mappedBy = "userId")
    private List<HistoryPay> historyList;
    @ManyToMany
    private Set<Authorities> authoritiesSet;
}
