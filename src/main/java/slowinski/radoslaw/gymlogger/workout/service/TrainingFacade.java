package slowinski.radoslaw.gymlogger.workout.service;

import slowinski.radoslaw.gymlogger.workout.entity.ExerciseLog;
import slowinski.radoslaw.gymlogger.workout.entity.SeriesLog;
import slowinski.radoslaw.gymlogger.workout.entity.TrainingLog;
import slowinski.radoslaw.gymlogger.workout.model.response.ExerciseLogResponse;
import slowinski.radoslaw.gymlogger.workout.model.response.SeriesLogResponse;
import slowinski.radoslaw.gymlogger.workout.model.response.TrainingLogResponse;

import java.time.LocalDate;

public interface TrainingFacade {
    SeriesLogResponse addSeriesLog(ExerciseLog exerciseLog, Integer reps, Float weight);

    ExerciseLogResponse createExerciseLog(String exerciseTitle, TrainingLog trainingLog);

    TrainingLogResponse createTrainingLog(LocalDate trainingDate);

    TrainingLogResponse getTrainingLog(Long trainingId);

    ExerciseLogResponse getExerciseLog(Long exerciseId);

    SeriesLogResponse getSeriesLog(Long seriesId);

    void deleteTrainingLog(TrainingLog trainingLog);

    void deleteExerciseLog(ExerciseLog exerciseLog);

    void deleteSeriesLog(SeriesLog seriesLog);
}
