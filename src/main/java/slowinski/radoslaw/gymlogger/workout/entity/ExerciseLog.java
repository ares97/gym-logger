package slowinski.radoslaw.gymlogger.workout.entity;

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

    private String exerciseTitle;

    @OneToMany
    private List<SeriesLog> seriesLogs;

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
