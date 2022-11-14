package infinity.mobiuzservice.repository;


import infinity.mobiuzservice.model.entity.MobiUz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface MobiUzRepository extends JpaRepository<MobiUz, Long> {
    Optional<MobiUz> findByPhoneNumber(String phoneNumber);
}