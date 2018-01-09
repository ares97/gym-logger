package slowinski.radoslaw.gymlogger.workout.service;

import slowinski.radoslaw.gymlogger.workout.entity.TrainingLog;

import java.time.LocalDate;
import java.util.List;

public interface TrainingLogService {

    void update(TrainingLog trainingLog);

    Long createTrainingLog(LocalDate trainingDate);

    List<TrainingLog> getTrainingLogs();
}
