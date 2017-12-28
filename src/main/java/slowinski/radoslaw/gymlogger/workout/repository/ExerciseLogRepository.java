package slowinski.radoslaw.gymlogger.workout.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import slowinski.radoslaw.gymlogger.workout.entity.ExerciseLog;

public interface ExerciseLogRepository extends JpaRepository<ExerciseLog, Long> {
}
