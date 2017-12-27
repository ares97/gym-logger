package slowinski.radoslaw.gymlogger.exercise.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import slowinski.radoslaw.gymlogger.exercise.entity.Exercise;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
    Exercise findByTitleIgnoreCase(String title);
}
