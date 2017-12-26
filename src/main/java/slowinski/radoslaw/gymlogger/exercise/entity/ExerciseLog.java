package slowinski.radoslaw.gymlogger.exercise.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class ExerciseLog {
    @GeneratedValue
    @Id
    private Long id;

    private Exercise exercise;

    @OneToMany
    private List<SeriesLog> seriesLogs;

    public ExerciseLog() {
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
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
