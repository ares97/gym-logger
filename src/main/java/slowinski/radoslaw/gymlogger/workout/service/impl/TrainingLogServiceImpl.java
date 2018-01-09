package slowinski.radoslaw.gymlogger.workout.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import slowinski.radoslaw.gymlogger.workout.entity.TrainingLog;
import slowinski.radoslaw.gymlogger.workout.repository.TrainingLogRepository;
import slowinski.radoslaw.gymlogger.workout.service.TrainingLogService;

import java.time.LocalDate;

@Service
public class TrainingLogServiceImpl implements TrainingLogService {

    @Autowired
    TrainingLogRepository trainingLogRepository;

    @Override
    public void update(TrainingLog trainingLog) {
        trainingLogRepository.save(trainingLog);
    }

    @Override
    public Long createTrainingLog(LocalDate trainingDate) {
        TrainingLog trainingLog = new TrainingLog();
        trainingLog.setTrainingDate(trainingDate);
        trainingLogRepository.save(trainingLog);

        return trainingLog.getId();
    }
}
