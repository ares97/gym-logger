package slowinski.radoslaw.gymlogger.workout.service;

import slowinski.radoslaw.gymlogger.workout.entity.ExerciseLog;

import java.util.List;

public interface ExerciseLogService {
    List<ExerciseLog> getExerciseLogs();

    void createExerciseLog(String exTitle);

    void updateExerciseLog(ExerciseLog exerciseLog);
}
