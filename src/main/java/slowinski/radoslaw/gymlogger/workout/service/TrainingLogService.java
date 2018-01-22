package slowinski.radoslaw.gymlogger.workout.service;

import slowinski.radoslaw.gymlogger.workout.entity.TrainingLog;
import slowinski.radoslaw.gymlogger.workout.model.response.TrainingLogResponse;

import java.time.LocalDate;

public interface TrainingLogService {

    void update(TrainingLog trainingLog);

    TrainingLogResponse createTrainingLog(LocalDate trainingDate);

    TrainingLogResponse getTrainingLogResponse(Long trainingId);

    void deleteTrainingLog(Long trainingLog);

    TrainingLog getTrainingLog(Long trainingId);
}
