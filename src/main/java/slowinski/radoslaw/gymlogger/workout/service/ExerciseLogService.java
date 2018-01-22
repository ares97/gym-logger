package slowinski.radoslaw.gymlogger.workout.service;

import slowinski.radoslaw.gymlogger.workout.entity.ExerciseLog;
import slowinski.radoslaw.gymlogger.workout.model.response.ExerciseLogResponse;

public interface ExerciseLogService {

    ExerciseLogResponse createExerciseLog(String exerciseTitle, Long trainingLog);

    void updateExerciseLog(ExerciseLog exerciseLog);

    ExerciseLogResponse getExerciseLogResponse(Long exerciseId);

    void deleteExerciseLog(Long exerciseLog);

    ExerciseLog getExerciseLog(Long exerciseId);
}
