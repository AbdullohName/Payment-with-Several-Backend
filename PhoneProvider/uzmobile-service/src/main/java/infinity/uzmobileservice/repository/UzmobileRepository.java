package infinity.uzmobileservice.repository;

import infinity.uzmobileservice.model.entity.Uzmobile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UzmobileRepository extends JpaRepository<Uzmobile, Long> {
    Optional<Uzmobile> findByPhoneNumber(String phoneNumber);
}