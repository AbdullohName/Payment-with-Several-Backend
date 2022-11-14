package infinity.ucellservice.repository;

import infinity.ucellservice.model.entity.UcellHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UcellHistoryRepository extends JpaRepository<UcellHistory, Long> {
}