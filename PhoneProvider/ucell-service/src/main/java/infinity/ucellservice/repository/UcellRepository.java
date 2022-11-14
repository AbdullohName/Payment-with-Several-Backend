package infinity.ucellservice.repository;

import infinity.ucellservice.model.entity.Ucell;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UcellRepository extends JpaRepository<Ucell, Long> {
    Optional<Ucell> findByPhoneNumber(String phoneNumber);
}