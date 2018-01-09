package slowinski.radoslaw.gymlogger.workout.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import slowinski.radoslaw.gymlogger.workout.entity.ExerciseLog;
import slowinski.radoslaw.gymlogger.workout.entity.TrainingLog;
import slowinski.radoslaw.gymlogger.workout.repository.ExerciseLogRepository;
import slowinski.radoslaw.gymlogger.workout.service.ExerciseLogService;
import slowinski.radoslaw.gymlogger.workout.service.TrainingLogService;

@Service
public class ExerciseLogServiceImpl implements ExerciseLogService {

    @Autowired
    ExerciseLogRepository exerciseLogRepository;
    @Autowired
    TrainingLogService trainingLogService;


    @Override
    public void createExerciseLog(String exerciseTitle, TrainingLog trainingLog) {
        ExerciseLog exerciseLog = new ExerciseLog();
        exerciseLog.setExerciseTitle(exerciseTitle);
        exerciseLogRepository.save(exerciseLog);

        trainingLog.getExerciseLogs().add(exerciseLog);
        trainingLogService.update(trainingLog);
    }

    @Override
    public void updateExerciseLog(ExerciseLog exerciseLog) {
        exerciseLogRepository.save(exerciseLog);
    }

}
