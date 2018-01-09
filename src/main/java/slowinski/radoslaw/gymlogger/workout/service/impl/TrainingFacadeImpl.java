package slowinski.radoslaw.gymlogger.workout.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import slowinski.radoslaw.gymlogger.workout.entity.ExerciseLog;
import slowinski.radoslaw.gymlogger.workout.entity.TrainingLog;
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
    public void addSeriesLog(ExerciseLog exerciseLog, Integer reps, Float weight) {
        seriesLogService.addSeries(exerciseLog, reps, weight);
    }

    @Override
    public void createExerciseLog(String exerciseTitle, TrainingLog trainingLog) {
        exerciseLogService.createExerciseLog(exerciseTitle, trainingLog);
    }

    @Override
    public Long createTrainingLog(LocalDate trainingDate) {
        return trainingLogService.createTrainingLog(trainingDate);
    }

    @Override
    public List<TrainingLog> getTrainingLogs() {
        return trainingLogService.getTrainingLogs();
    }
}
