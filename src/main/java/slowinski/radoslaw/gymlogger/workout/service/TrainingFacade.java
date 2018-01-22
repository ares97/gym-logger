package slowinski.radoslaw.gymlogger.workout.service;

import slowinski.radoslaw.gymlogger.workout.model.response.ExerciseLogResponse;
import slowinski.radoslaw.gymlogger.workout.model.response.SeriesLogResponse;
import slowinski.radoslaw.gymlogger.workout.model.response.TrainingLogResponse;

import java.time.LocalDate;
import java.util.List;

public interface TrainingFacade {
    SeriesLogResponse createSeriesLog(Long exerciseLog, Integer reps, Float weight);

    ExerciseLogResponse createExerciseLog(String exerciseTitle, Long trainingLogId);

    TrainingLogResponse createTrainingLog(LocalDate trainingDate);

    TrainingLogResponse getTrainingLogResponse(Long trainingId);

    ExerciseLogResponse getExerciseLogResponse(Long exerciseId);

    SeriesLogResponse getSeriesLogResponse(Long seriesId);

    void deleteTrainingLog(Long trainingLog);

    void deleteExerciseLog(Long exerciseLog);

    void deleteSeriesLog(Long seriesLog);

    List<TrainingLogResponse> getTrainingLogsForCurrentUser();
}
