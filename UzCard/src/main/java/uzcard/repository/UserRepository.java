package uzcard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uzcard.entity.Users;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    Optional<Users> findFirstByUsername(String userName);
}