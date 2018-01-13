package slowinski.radoslaw.gymlogger.workout.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import slowinski.radoslaw.gymlogger.user.service.UserService;
import slowinski.radoslaw.gymlogger.workout.entity.ExerciseLog;
import slowinski.radoslaw.gymlogger.workout.entity.SeriesLog;
import slowinski.radoslaw.gymlogger.workout.entity.TrainingLog;
import slowinski.radoslaw.gymlogger.workout.model.response.ExerciseLogResponse;
import slowinski.radoslaw.gymlogger.workout.model.response.SeriesLogResponse;
import slowinski.radoslaw.gymlogger.workout.model.response.TrainingLogResponse;
import slowinski.radoslaw.gymlogger.workout.service.ExerciseLogService;
import slowinski.radoslaw.gymlogger.workout.service.SeriesLogService;
import slowinski.radoslaw.gymlogger.workout.service.TrainingFacade;
import slowinski.radoslaw.gymlogger.workout.service.TrainingLogService;

import java.time.LocalDate;
import java.util.List;

@Component
public class TrainingFacadeImpl implements TrainingFacade {

    @Autowired
    private TrainingLogService trainingLogService;
    @Autowired
    private ExerciseLogService exerciseLogService;
    @Autowired
    private SeriesLogService seriesLogService;
    @Autowired
    private UserService userService;

    @Override
    public SeriesLogResponse addSeriesLog(ExerciseLog exerciseLog, Integer reps, Float weight) {
        return seriesLogService.addSeriesLog(exerciseLog, reps, weight);
    }

    @Override
    public ExerciseLogResponse createExerciseLog(String exerciseTitle, TrainingLog trainingLog) {
        return exerciseLogService.createExerciseLog(exerciseTitle, trainingLog);
    }

    @Override
    public TrainingLogResponse createTrainingLog(LocalDate trainingDate) {
        return trainingLogService.createTrainingLog(trainingDate);
    }

    @Override
    public TrainingLogResponse getTrainingLogResponse(Long trainingId) {
        return trainingLogService.getTrainingLogResponse(trainingId);
    }

    @Override
    public ExerciseLogResponse getExerciseLogResponse(Long exerciseId) {
        return exerciseLogService.getExerciseLogResponse(exerciseId);
    }

    @Override
    public SeriesLogResponse getSeriesLogResponse(Long seriesId) {
        return seriesLogService.getSeriesLogResponse(seriesId);
    }

    @Override
    public void deleteTrainingLog(TrainingLog trainingLog) {
        trainingLogService.deleteTrainingLog(trainingLog);
    }

    @Override
    public void deleteExerciseLog(ExerciseLog exerciseLog) {
        exerciseLogService.deleteExerciseLog(exerciseLog);
    }

    @Override
    public void deleteSeriesLog(SeriesLog seriesLog) {
        seriesLogService.deleteSeriesLog(seriesLog);
    }

    @Override
    public List<TrainingLogResponse> getTrainingLogResponses() {
        return userService.getTrainingLogs();
    }
}
