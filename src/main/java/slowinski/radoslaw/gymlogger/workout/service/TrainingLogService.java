package slowinski.radoslaw.gymlogger.workout.service;

import slowinski.radoslaw.gymlogger.workout.entity.TrainingLog;
import slowinski.radoslaw.gymlogger.workout.model.response.TrainingLogResponse;

import java.time.LocalDate;
import java.util.List;

public interface TrainingLogService {

    void update(TrainingLog trainingLog);

    TrainingLogResponse createTrainingLog(LocalDate trainingDate);

    List<TrainingLog> getTrainingLogs();

    TrainingLogResponse getTrainingLog(Long trainingId);
}
