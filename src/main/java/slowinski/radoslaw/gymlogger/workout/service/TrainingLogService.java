package slowinski.radoslaw.gymlogger.workout.service;

import slowinski.radoslaw.gymlogger.workout.entity.TrainingLog;

import java.time.LocalDate;

public interface TrainingLogService {

    void update(TrainingLog trainingLog);

    Long createTrainingLog(LocalDate trainingDate);
}
