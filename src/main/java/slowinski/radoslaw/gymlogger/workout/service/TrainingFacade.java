package slowinski.radoslaw.gymlogger.workout.service;

import slowinski.radoslaw.gymlogger.workout.entity.ExerciseLog;
import slowinski.radoslaw.gymlogger.workout.entity.TrainingLog;

import java.time.LocalDate;
import java.util.List;

public interface TrainingFacade {
    void addSeriesLog(ExerciseLog exerciseLog, Integer reps, Float weight);

    void createExerciseLog(String exerciseTitle, TrainingLog trainingLog);

    Long createTrainingLog(LocalDate trainingDate);

    List<TrainingLog> getTrainingLogs();
}
