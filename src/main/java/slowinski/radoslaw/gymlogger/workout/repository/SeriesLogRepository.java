package slowinski.radoslaw.gymlogger.workout.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import slowinski.radoslaw.gymlogger.workout.entity.SeriesLog;

public interface SeriesLogRepository extends JpaRepository<SeriesLog, Long> {
}
