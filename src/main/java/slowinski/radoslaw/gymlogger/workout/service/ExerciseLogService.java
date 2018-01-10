package slowinski.radoslaw.gymlogger.workout.service;

import slowinski.radoslaw.gymlogger.workout.entity.ExerciseLog;
import slowinski.radoslaw.gymlogger.workout.entity.TrainingLog;
import slowinski.radoslaw.gymlogger.workout.model.response.ExerciseLogResponse;

public interface ExerciseLogService {

    ExerciseLogResponse createExerciseLog(String exerciseTitle, TrainingLog trainingLog);

    void updateExerciseLog(ExerciseLog exerciseLog);
}
