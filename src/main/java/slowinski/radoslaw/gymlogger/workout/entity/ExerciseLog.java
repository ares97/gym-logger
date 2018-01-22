package slowinski.radoslaw.gymlogger.workout.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "exerciseLog")
public class ExerciseLog {
    @GeneratedValue
    @Id
    private Long id;

    private String exerciseTitle;

    @OneToMany(orphanRemoval = true, mappedBy = "exerciseLog")
    private List<SeriesLog> seriesLogs;

    @ManyToOne
    private TrainingLog trainingLog;

    public ExerciseLog(String exerciseTitle, TrainingLog trainingLog) {
        this.exerciseTitle = exerciseTitle;
        this.trainingLog = trainingLog;
    }

    public ExerciseLog() {
    }

    public Long getId() {
        return id;
    }

    public String getExerciseTitle() {
        return exerciseTitle;
    }

    public List<SeriesLog> getSeriesLogs() {
        return seriesLogs;
    }

    public TrainingLog getTrainingLog() {
        return trainingLog;
    }
}
