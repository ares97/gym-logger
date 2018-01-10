package slowinski.radoslaw.gymlogger.workout.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import slowinski.radoslaw.gymlogger.workout.entity.ExerciseLog;
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

public class TrainingFacadeImpl implements TrainingFacade {

    @Autowired
    private TrainingLogService trainingLogService;
    @Autowired
    private ExerciseLogService exerciseLogService;
    @Autowired
    private SeriesLogService seriesLogService;

    @Override
    public SeriesLogResponse addSeriesLog(ExerciseLog exerciseLog, Integer reps, Float weight) {
        return seriesLogService.addSeries(exerciseLog, reps, weight);
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
    public List<TrainingLog> getTrainingLogs() {
        return trainingLogService.getTrainingLogs();
    }

    @Override
    public TrainingLogResponse getTrainingLog(Long trainingId) {
        return trainingLogService.getTrainingLog(trainingId);
    }

    @Override
    public ExerciseLogResponse getExerciseLog(Long exerciseId) {
        return exerciseLogService.getExerciseLog(exerciseId);
    }

    @Override
    public SeriesLogResponse getSeriesLog(Long seriesId) {
        return seriesLogService.getSeriesLog(seriesId);
    }
}
