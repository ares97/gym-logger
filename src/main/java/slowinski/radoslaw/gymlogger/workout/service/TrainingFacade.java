package slowinski.radoslaw.gymlogger.workout.service;

import slowinski.radoslaw.gymlogger.workout.entity.ExerciseLog;
import slowinski.radoslaw.gymlogger.workout.entity.TrainingLog;
import slowinski.radoslaw.gymlogger.workout.model.response.TrainingLogResponse;

import java.time.LocalDate;
import java.util.List;

public interface TrainingFacade {
    void addSeriesLog(ExerciseLog exerciseLog, Integer reps, Float weight);

    void createExerciseLog(String exerciseTitle, TrainingLog trainingLog);

    TrainingLogResponse createTrainingLog(LocalDate trainingDate);

    List<TrainingLog> getTrainingLogs();
}
