package slowinski.radoslaw.gymlogger.workout.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import slowinski.radoslaw.gymlogger.workout.entity.ExerciseLog;
import slowinski.radoslaw.gymlogger.workout.entity.TrainingLog;
import slowinski.radoslaw.gymlogger.workout.repository.TrainingLogRepository;
import slowinski.radoslaw.gymlogger.workout.service.TrainingLogService;

import java.time.LocalDate;
import java.util.List;

@Service
public class TrainingLogServiceImpl implements TrainingLogService {

    @Autowired
    TrainingLogRepository trainingLogRepository;

    @Override
    public List<TrainingLog> getTrainingLogs() {
        return trainingLogRepository.findAll();
    }

    @Override
    public void addExerciseLogToTrainingLog(TrainingLog trainingLog, ExerciseLog exerciseLog) {
        trainingLog.getExerciseLogs().add(exerciseLog);
        trainingLogRepository.save(trainingLog);
    }

    @Override
    public void addEmptyTrainingLog(LocalDate trainingDate) {
        TrainingLog trainingLog = new TrainingLog();
        trainingLog.setTrainingDate(trainingDate);
    }

}
