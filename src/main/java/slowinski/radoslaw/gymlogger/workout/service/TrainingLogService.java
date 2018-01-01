package slowinski.radoslaw.gymlogger.workout.service;

import slowinski.radoslaw.gymlogger.workout.entity.ExerciseLog;
import slowinski.radoslaw.gymlogger.workout.entity.TrainingLog;

import java.time.LocalDate;
import java.util.List;

public interface TrainingLogService {
    List<TrainingLog> getTrainingLogs();

    void addExerciseLogToTrainingLog(TrainingLog trainingLog, ExerciseLog exerciseLog);

    void addEmptyTrainingLog(LocalDate trainingDate);

}
