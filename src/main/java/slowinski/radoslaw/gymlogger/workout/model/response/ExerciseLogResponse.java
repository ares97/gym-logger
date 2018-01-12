package slowinski.radoslaw.gymlogger.workout.model.response;

import slowinski.radoslaw.gymlogger.workout.model.Links;

import java.util.List;

public class ExerciseLogResponse {

    private Long id;

    private Links links;

    private String exerciseTitle;

    private List<SeriesLogResponse> seriesLogs;

    private Long trainingLogId;

    public Long getTrainingLogId() {
        return trainingLogId;
    }

    public void setTrainingLogId(Long trainingLogId) {
        this.trainingLogId = trainingLogId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public String getExerciseTitle() {
        return exerciseTitle;
    }

    public void setExerciseTitle(String exerciseTitle) {
        this.exerciseTitle = exerciseTitle;
    }

    public List<SeriesLogResponse> getSeriesLogs() {
        return seriesLogs;
    }

    public void setSeriesLogs(List<SeriesLogResponse> seriesLogs) {
        this.seriesLogs = seriesLogs;
    }
}
