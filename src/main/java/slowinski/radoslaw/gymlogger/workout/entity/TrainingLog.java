package slowinski.radoslaw.gymlogger.workout.entity;

import slowinski.radoslaw.gymlogger.user.entity.User;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "trainingLog")
public class TrainingLog {

    @GeneratedValue
    @Id
    private Long id;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "trainingLog")
    private List<ExerciseLog> exerciseLogs;

    @ManyToOne
    private User user;

    private LocalDate trainingDate;

    public TrainingLog() {
    }

    public TrainingLog(User user, LocalDate trainingDate) {
        this.user = user;
        this.trainingDate = trainingDate;
    }

    public Long getId() {
        return id;
    }

    public List<ExerciseLog> getExerciseLogs() {
        return exerciseLogs;
    }

    public User getUser() {
        return user;
    }

    public LocalDate getTrainingDate() {
        return trainingDate;
    }
}
