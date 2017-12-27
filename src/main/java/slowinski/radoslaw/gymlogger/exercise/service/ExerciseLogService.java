package slowinski.radoslaw.gymlogger.exercise.service;

import slowinski.radoslaw.gymlogger.exercise.entity.ExerciseLog;

import java.util.List;

public interface ExerciseLogService {
    List<ExerciseLog> getExerciseLogs();

    void createExerciseLog(String exTitle);

    void updateExerciseLog(ExerciseLog exerciseLog);
}
