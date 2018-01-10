package slowinski.radoslaw.gymlogger.workout.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import slowinski.radoslaw.gymlogger.workout.entity.ExerciseLog;
import slowinski.radoslaw.gymlogger.workout.entity.SeriesLog;
import slowinski.radoslaw.gymlogger.workout.model.response.SeriesLogResponse;
import slowinski.radoslaw.gymlogger.workout.repository.SeriesLogRepository;
import slowinski.radoslaw.gymlogger.workout.service.ExerciseLogService;
import slowinski.radoslaw.gymlogger.workout.service.SeriesLogService;

@Service
public class SeriesLogServiceImpl implements SeriesLogService {

    @Autowired
    SeriesLogRepository seriesLogRepository;
    @Autowired
    ExerciseLogService exerciseLogService;
    @Autowired
    ConversionService conversionService;


    @Override
    public SeriesLogResponse addSeries(ExerciseLog exerciseLog, Integer reps, Float weight) {
        SeriesLog seriesLog = new SeriesLog();
        seriesLog.setReps(reps);
        seriesLog.setWeight(weight);
        seriesLogRepository.save(seriesLog);

        exerciseLog.getSeriesLogs().add(seriesLog);
        exerciseLogService.updateExerciseLog(exerciseLog);

        return conversionService.convert(seriesLog, SeriesLogResponse.class);
    }
}
