package slowinski.radoslaw.gymlogger.workout.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class ExerciseLog {
    @GeneratedValue
    @Id
    private Long id;

    private String exerciseTitle;

    @OneToMany(orphanRemoval = true, mappedBy = "exerciseLog")
    private List<SeriesLog> seriesLogs;

    @ManyToOne
    private TrainingLog trainingLog;

    public TrainingLog getTrainingLog() {
        return trainingLog;
    }

    public void setTrainingLog(TrainingLog trainingLog) {
        this.trainingLog = trainingLog;
    }

    public String getExerciseTitle() {
        return exerciseTitle;
    }

    public void setExerciseTitle(String exerciseTitle) {
        this.exerciseTitle = exerciseTitle;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<SeriesLog> getSeriesLogs() {
        return seriesLogs;
    }

    public void setSeriesLogs(List<SeriesLog> seriesLogs) {
        this.seriesLogs = seriesLogs;
    }
}
