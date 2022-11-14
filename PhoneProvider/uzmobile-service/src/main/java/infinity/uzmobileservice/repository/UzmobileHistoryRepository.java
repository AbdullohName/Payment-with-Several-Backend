package infinity.uzmobileservice.repository;

import infinity.uzmobileservice.model.entity.UzmobileHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UzmobileHistoryRepository extends JpaRepository<UzmobileHistory, Long> {
}