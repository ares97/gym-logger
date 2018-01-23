package slowinski.radoslaw.gymlogger.workout.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import slowinski.radoslaw.gymlogger.exception.WorkoutNotFoundException;
import slowinski.radoslaw.gymlogger.workout.entity.ExerciseLog;
import slowinski.radoslaw.gymlogger.workout.entity.SeriesLog;
import slowinski.radoslaw.gymlogger.workout.model.response.SeriesLogResponse;
import slowinski.radoslaw.gymlogger.workout.repository.SeriesLogRepository;
import slowinski.radoslaw.gymlogger.workout.service.ExerciseLogService;
import slowinski.radoslaw.gymlogger.workout.service.SeriesLogService;

import java.util.Optional;

@Service
class SeriesLogServiceImpl implements SeriesLogService {

    @Autowired
    SeriesLogRepository seriesLogRepository;
    @Autowired
    ExerciseLogService exerciseLogService;
    @Autowired
    ConversionService conversionService;


    @Override
    public SeriesLogResponse createSeriesLog(Long exerciseLogId, Integer reps, Float weight) {
        ExerciseLog exerciseLog = exerciseLogService.getExerciseLog(exerciseLogId);
        SeriesLog seriesLog = new SeriesLog(weight, reps, exerciseLog);
        seriesLogRepository.save(seriesLog);

        exerciseLog.getSeriesLogs().add(seriesLog);
        exerciseLogService.updateExerciseLog(exerciseLog);

        return conversionService.convert(seriesLog, SeriesLogResponse.class);
    }

    @Override
    public SeriesLogResponse getSeriesLogResponse(Long seriesId) {
        Optional<SeriesLog> seriesLog = Optional.ofNullable(seriesLogRepository.findOne(seriesId));

        return conversionService.convert(seriesLog.orElseThrow(
                () -> new WorkoutNotFoundException("could not find series log with id#" + seriesId)),
                SeriesLogResponse.class);
    }

    @Override
    public void deleteSeriesLog(Long seriesLogId) {
        try {
            seriesLogRepository.delete(seriesLogId);
        } catch (Exception ex) {
            throw new WorkoutNotFoundException("could find series log with id#" + seriesLogId);
        }
    }

    @Override
    public SeriesLog getSeriesLog(Long seriesId) {
        return Optional.ofNullable(seriesLogRepository.
                findOne(seriesId)).
                orElseThrow(() -> new WorkoutNotFoundException("could not find series log with id#" + seriesId));
    }
}
