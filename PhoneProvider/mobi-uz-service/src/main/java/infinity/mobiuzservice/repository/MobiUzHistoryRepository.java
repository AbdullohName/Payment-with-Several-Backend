package infinity.mobiuzservice.repository;


import infinity.mobiuzservice.model.entity.MobiUzHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MobiUzHistoryRepository extends JpaRepository<MobiUzHistory, Long> {
}