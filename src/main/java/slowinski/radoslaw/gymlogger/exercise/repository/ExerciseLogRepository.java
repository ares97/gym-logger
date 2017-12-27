package slowinski.radoslaw.gymlogger.exercise.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import slowinski.radoslaw.gymlogger.exercise.entity.ExerciseLog;

public interface ExerciseLogRepository extends JpaRepository<ExerciseLog, Long> {
}
