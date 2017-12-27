package slowinski.radoslaw.gymlogger.exercise.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import slowinski.radoslaw.gymlogger.exercise.entity.ExerciseLog;
import slowinski.radoslaw.gymlogger.exercise.repository.ExerciseLogRepository;
import slowinski.radoslaw.gymlogger.exercise.service.ExerciseLogService;

import java.util.List;

@Service
public class ExerciseLogServiceImpl implements ExerciseLogService {

    @Autowired
    ExerciseLogRepository exerciseLogRepository;


    @Override
    public List<ExerciseLog> getExerciseLogs() {
        return exerciseLogRepository.findAll();
    }

    @Override
    public void addExerciseLog(ExerciseLog exerciseLog) {
        exerciseLogRepository.save(exerciseLog);
    }
}
