package slowinski.radoslaw.gymlogger.workout.service;

import slowinski.radoslaw.gymlogger.workout.entity.TrainingLog;

import java.util.List;

public interface TrainingLogService {
    List<TrainingLog> getTrainingLogs();
}
