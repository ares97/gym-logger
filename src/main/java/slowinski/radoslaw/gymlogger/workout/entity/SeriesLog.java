package slowinski.radoslaw.gymlogger.workout.entity;

import javax.persistence.*;

@Entity
@Table(name = "seriesLog")
public class SeriesLog {

    @GeneratedValue
    @Id
    private Long id;

    private float weight;

    private int reps;

    @ManyToOne
    private ExerciseLog exerciseLog;

    public SeriesLog(float weight, int reps, ExerciseLog exerciseLog) {
        this.weight = weight;
        this.reps = reps;
        this.exerciseLog = exerciseLog;
    }

    public SeriesLog() {
    }

    public Long getId() {
        return id;
    }

    public float getWeight() {
        return weight;
    }

    public int getReps() {
        return reps;
    }

    public ExerciseLog getExerciseLog() {
        return exerciseLog;
    }
}
