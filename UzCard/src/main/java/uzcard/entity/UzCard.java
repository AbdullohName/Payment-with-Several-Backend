package uzcard.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class UzCard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "uzcard_id_seq")
    private Integer id;
    private String fullName;
    private Date validThru;
    private String phoneNumber;
    private Double balance;
    @Column(unique = true)
    private String passportId;
    @Column(unique = true)
    private String cardNumber;
    private Integer pinCode;
    private Boolean sms;
    private String bankName;
}
