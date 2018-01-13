package slowinski.radoslaw.gymlogger.workout.service;

import slowinski.radoslaw.gymlogger.workout.entity.ExerciseLog;
import slowinski.radoslaw.gymlogger.workout.entity.SeriesLog;
import slowinski.radoslaw.gymlogger.workout.entity.TrainingLog;
import slowinski.radoslaw.gymlogger.workout.model.response.ExerciseLogResponse;
import slowinski.radoslaw.gymlogger.workout.model.response.SeriesLogResponse;
import slowinski.radoslaw.gymlogger.workout.model.response.TrainingLogResponse;

import java.time.LocalDate;
import java.util.List;

public interface TrainingFacade {
    SeriesLogResponse addSeriesLog(ExerciseLog exerciseLog, Integer reps, Float weight);

    ExerciseLogResponse createExerciseLog(String exerciseTitle, TrainingLog trainingLog);

    TrainingLogResponse createTrainingLog(LocalDate trainingDate);

    TrainingLogResponse getTrainingLogResponse(Long trainingId);

    ExerciseLogResponse getExerciseLogResponse(Long exerciseId);

    SeriesLogResponse getSeriesLogResponse(Long seriesId);

    void deleteTrainingLog(TrainingLog trainingLog);

    void deleteExerciseLog(ExerciseLog exerciseLog);

    void deleteSeriesLog(SeriesLog seriesLog);

    List<TrainingLogResponse> getTrainingLogResponses();
}
