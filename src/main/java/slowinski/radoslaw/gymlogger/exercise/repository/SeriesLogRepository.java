package slowinski.radoslaw.gymlogger.exercise.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import slowinski.radoslaw.gymlogger.exercise.entity.SeriesLog;

public interface SeriesLogRepository extends JpaRepository<SeriesLog, Long> {
}
