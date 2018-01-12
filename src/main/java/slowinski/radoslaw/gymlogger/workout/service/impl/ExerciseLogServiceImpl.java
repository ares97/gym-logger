package slowinski.radoslaw.gymlogger.workout.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import slowinski.radoslaw.gymlogger.workout.entity.ExerciseLog;
import slowinski.radoslaw.gymlogger.workout.entity.TrainingLog;
import slowinski.radoslaw.gymlogger.workout.exception.WorkoutNotFoundException;
import slowinski.radoslaw.gymlogger.workout.model.response.ExerciseLogResponse;
import slowinski.radoslaw.gymlogger.workout.repository.ExerciseLogRepository;
import slowinski.radoslaw.gymlogger.workout.service.ExerciseLogService;
import slowinski.radoslaw.gymlogger.workout.service.TrainingLogService;

import java.util.Optional;

@Service
public class ExerciseLogServiceImpl implements ExerciseLogService {

    @Autowired
    ExerciseLogRepository exerciseLogRepository;
    @Autowired
    TrainingLogService trainingLogService;
    @Autowired
    ConversionService conversionService;


    @Override
    public ExerciseLogResponse createExerciseLog(String exerciseTitle, TrainingLog trainingLog) {
        ExerciseLog exerciseLog = new ExerciseLog();
        exerciseLog.setExerciseTitle(exerciseTitle);
        exerciseLog.setTrainingLog(trainingLog);
        exerciseLogRepository.save(exerciseLog);

        trainingLog.getExerciseLogs().add(exerciseLog);
        trainingLogService.update(trainingLog);

        return conversionService.convert(exerciseLog, ExerciseLogResponse.class);
    }

    @Override
    public void updateExerciseLog(ExerciseLog exerciseLog) {
        exerciseLogRepository.save(exerciseLog);
    }

    @Override
    public ExerciseLogResponse getExerciseLog(Long exerciseId) {
        Optional<ExerciseLog> exerciseLog = Optional.ofNullable(exerciseLogRepository.findOne(exerciseId));

        return conversionService.convert(exerciseLog.orElseThrow(
                () -> new WorkoutNotFoundException("could not find exercise log with id#" + exerciseId)),
                ExerciseLogResponse.class);
    }

    @Override
    public void deleteExerciseLog(ExerciseLog exerciseLog) {
        exerciseLogRepository.delete(exerciseLog);
    }

}
