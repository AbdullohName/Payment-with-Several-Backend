package infinity.perfectumservice.repository;

import infinity.perfectumservice.model.entity.PerfectumHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfectumHistoryRepository extends JpaRepository<PerfectumHistory, Long> {
}