package slowinski.radoslaw.gymlogger.exercise.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import slowinski.radoslaw.gymlogger.exercise.entity.Exercise;
import slowinski.radoslaw.gymlogger.exercise.entity.ExerciseLog;
import slowinski.radoslaw.gymlogger.exercise.repository.ExerciseLogRepository;
import slowinski.radoslaw.gymlogger.exercise.service.ExerciseLogService;
import slowinski.radoslaw.gymlogger.exercise.service.ExerciseService;

import java.util.List;

@Service
public class ExerciseLogServiceImpl implements ExerciseLogService {

    @Autowired
    ExerciseLogRepository exerciseLogRepository;
    @Autowired
    ExerciseService exerciseService;

    @Override
    public List<ExerciseLog> getExerciseLogs() {
        return exerciseLogRepository.findAll();
    }

    @Override
    public void createExerciseLog(String exerciseTitle) {
        ExerciseLog exLog = new ExerciseLog();
        exLog.setExercise(getExerciseForLog(exerciseTitle));

        exerciseLogRepository.save(exLog);
    }

    @Override
    public void updateExerciseLog(ExerciseLog exerciseLog) {
        exerciseLogRepository.save(exerciseLog);
    }

    private Exercise getExerciseForLog(String exerciseTitle) {
        Exercise exercise = exerciseService.findExerciseByTitle(exerciseTitle);

        if (exercise == null)
            exercise = exerciseService.createCustomExercise(exerciseTitle);

        return exercise;
    }
}
