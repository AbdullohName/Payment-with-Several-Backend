package uzcard.repository;

import org.hibernate.annotations.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uzcard.entity.History;

import java.util.Optional;

public interface HistoryRepository extends JpaRepository<History, Long> {
    Optional<History> findFirstByTransactionId(Long id);

    void deleteByTransactionId(Integer id);
}