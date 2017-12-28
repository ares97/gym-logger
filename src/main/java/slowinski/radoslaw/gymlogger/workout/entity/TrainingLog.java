package slowinski.radoslaw.gymlogger.workout.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;

@Entity
public class TrainingLog {

    @GeneratedValue
    @Id
    private Long id;

    @OneToMany
    private List<ExerciseLog> exerciseLogs;

    private LocalDate trainingDate;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ExerciseLog> getExerciseLogs() {
        return exerciseLogs;
    }

    public void setExerciseLogs(List<ExerciseLog> exerciseLogs) {
        this.exerciseLogs = exerciseLogs;
    }

    public LocalDate getTrainingDate() {
        return trainingDate;
    }

    public void setTrainingDate(LocalDate trainingDate) {
        this.trainingDate = trainingDate;
    }
}
