package uzcard.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Entity @AllArgsConstructor @NoArgsConstructor
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "history_id_seq")
    private Long id;
    private String cardNumberAddMoney;
    private Double price;
    private Long transactionId;
    private Date date;
    private Boolean acceptPay = true;
    private String cardNumberTakeOff;
    public Boolean getAcceptPay() {
        return acceptPay;
    }

    public String getCardNumberTakeOff() {
        return cardNumberTakeOff;
    }

    public void setCardNumberTakeOff(String cardNumberTakeOff) {
        this.cardNumberTakeOff = cardNumberTakeOff;
    }

    public String getCardNumberAddMoney() {
        return cardNumberAddMoney;
    }

    public void setCardNumberAddMoney(String cardNumberAddMoney) {
        this.cardNumberAddMoney = cardNumberAddMoney;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
