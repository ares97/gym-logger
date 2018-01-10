package slowinski.radoslaw.gymlogger.workout.model.response;


import slowinski.radoslaw.gymlogger.workout.model.Links;

import java.time.LocalDate;
import java.util.List;

public class TrainingLogResponse {

    private Long id;

    private Links links;

    private List<ExerciseLogResponse> exerciseLogs;

    private LocalDate trainingDate;

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ExerciseLogResponse> getExerciseLogs() {
        return exerciseLogs;
    }

    public void setExerciseLogs(List<ExerciseLogResponse> exerciseLogs) {
        this.exerciseLogs = exerciseLogs;
    }

    public LocalDate getTrainingDate() {
        return trainingDate;
    }

    public void setTrainingDate(LocalDate trainingDate) {
        this.trainingDate = trainingDate;
    }
}
