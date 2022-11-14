package com.example.easypay.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class HistoryPay {                   // Tolov history
    @Id
    @GeneratedValue(generator = "history_id_seq",strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "full_name")
    private String fullName;

    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "payment_number")
    private Long paymentNumber;
    private Double pay;
    @Column(name = "cash_back")
    private Double cashBack;
    private Date date;
    private Long userId;
    private Boolean paymentSuccess = true;

    public Long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Long getPaymentNumber() {
        return paymentNumber;
    }

    public void setPaymentNumber(Long paymentNumber) {
        this.paymentNumber = paymentNumber;
    }

    public Double getPay() {
        return pay;
    }

    public void setPay(Double pay) {
        this.pay = pay;
    }

    public Double getCashBack() {
        return cashBack;
    }

    public void setCashBack(Double cashBack) {
        this.cashBack = cashBack;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Boolean getPaymentSuccess() {
        return paymentSuccess;
    }

    public void setPaymentSuccess(Boolean paymentSuccess) {
        this.paymentSuccess = paymentSuccess;
    }
}
