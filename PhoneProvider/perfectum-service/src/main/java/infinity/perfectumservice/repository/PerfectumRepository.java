package infinity.perfectumservice.repository;
import infinity.perfectumservice.model.entity.Perfectum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface PerfectumRepository extends JpaRepository<Perfectum, Long> {
    Optional<Perfectum> findByPhoneNumber(String phoneNumber);
}