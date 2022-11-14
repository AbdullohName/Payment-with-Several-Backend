package infinity.beelineservice.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity @Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Beeline {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "beeline_id_seq")
    private Long id;
    private String fullName;
    @Column(unique = true)
    private String passportNumber;
    private Double account;
    @Column(unique = true)
    private String phoneNumber;
    private String gmail;
}
