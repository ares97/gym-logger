package slowinski.radoslaw.gymlogger.workout.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import slowinski.radoslaw.gymlogger.user.service.UserService;
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
class TrainingFacadeImpl implements TrainingFacade {

    @Autowired
    private TrainingLogService trainingLogService;
    @Autowired
    private ExerciseLogService exerciseLogService;
    @Autowired
    private SeriesLogService seriesLogService;
    @Autowired
    private UserService userService;

    @Override
    public SeriesLogResponse createSeriesLog(Long exerciseLogId, Integer reps, Float weight) {
        return seriesLogService.createSeriesLog(exerciseLogId, reps, weight);
    }

    @Override
    public ExerciseLogResponse createExerciseLog(String exerciseTitle, Long trainingLogId) {
        return exerciseLogService.createExerciseLog(exerciseTitle, trainingLogId);
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
    public void deleteTrainingLog(Long trainingLog) {
        trainingLogService.deleteTrainingLog(trainingLog);
    }

    @Override
    public void deleteExerciseLog(Long exerciseLogId) {
        exerciseLogService.deleteExerciseLog(exerciseLogId);
    }

    @Override
    public void deleteSeriesLog(Long seriesLogId) {
        seriesLogService.deleteSeriesLog(seriesLogId);
    }

    @Override
    public List<TrainingLogResponse> getTrainingLogsForCurrentUser() {
        return userService.getTrainingLogs();
    }
}
