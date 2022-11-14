package infinity.beelineservice.repository;


import infinity.beelineservice.model.entity.BeelineHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeelineHistoryRepository extends JpaRepository<BeelineHistory, Long> {
}