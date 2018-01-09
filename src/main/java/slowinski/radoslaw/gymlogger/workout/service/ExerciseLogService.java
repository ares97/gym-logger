package slowinski.radoslaw.gymlogger.workout.service;

import slowinski.radoslaw.gymlogger.workout.entity.ExerciseLog;
import slowinski.radoslaw.gymlogger.workout.entity.TrainingLog;

public interface ExerciseLogService {

    void createExerciseLog(String exerciseTitle, TrainingLog trainingLog);

    void updateExerciseLog(ExerciseLog exerciseLog);
}