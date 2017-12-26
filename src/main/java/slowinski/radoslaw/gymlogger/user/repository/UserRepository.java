package slowinski.radoslaw.gymlogger.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import slowinski.radoslaw.gymlogger.user.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
