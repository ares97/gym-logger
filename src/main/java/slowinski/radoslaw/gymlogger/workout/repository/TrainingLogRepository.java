package slowinski.radoslaw.gymlogger.workout.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import slowinski.radoslaw.gymlogger.workout.entity.TrainingLog;

public interface TrainingLogRepository extends JpaRepository<TrainingLog, Long> {
}
