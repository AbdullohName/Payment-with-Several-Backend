package uzcard.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity @Data
public class Authorities {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "authorities_id_seq")
    private Long id;
    private String name;
}
