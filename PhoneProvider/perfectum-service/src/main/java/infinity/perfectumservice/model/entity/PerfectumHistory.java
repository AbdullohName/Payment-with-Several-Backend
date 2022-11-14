package infinity.perfectumservice.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class PerfectumHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "perfectum_history_seq")
    private Long id;
    private String fullName;
    private String passportNumber;
    private Double moneyPaid;
    private String phoneNumber;
    private Long transAcId;
}
