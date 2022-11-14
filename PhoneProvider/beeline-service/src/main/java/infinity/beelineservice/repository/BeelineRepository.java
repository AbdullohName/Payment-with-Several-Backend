package infinity.beelineservice.repository;


import infinity.beelineservice.model.entity.Beeline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface BeelineRepository extends JpaRepository<Beeline, Long> {
    Optional<Beeline> findByPhoneNumber(String phoneNumber);
}