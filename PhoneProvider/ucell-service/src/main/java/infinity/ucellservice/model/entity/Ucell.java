package infinity.ucellservice.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ucell {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "ucell_id_seq")
    private Long id;
    private String fullName;
    @Column(unique = true)
    private String passportNumber;
    private Double account;
    @Column(unique = true)
    private String phoneNumber;
    private String gmail;
}
