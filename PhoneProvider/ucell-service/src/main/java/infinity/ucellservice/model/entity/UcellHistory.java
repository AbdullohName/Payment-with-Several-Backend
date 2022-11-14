package infinity.ucellservice.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class UcellHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "ucell_history_id_seq")
    private Long id;
    private String fullName;
    private String passportNumber;
    private Double moneyPaid;
    private String phoneNumber;
    private Long transAcId;
}
