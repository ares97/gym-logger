package slowinski.radoslaw.gymlogger.workout.service;

import slowinski.radoslaw.gymlogger.workout.entity.ExerciseLog;
import slowinski.radoslaw.gymlogger.workout.entity.SeriesLog;
import slowinski.radoslaw.gymlogger.workout.model.response.SeriesLogResponse;

public interface SeriesLogService {

    SeriesLogResponse addSeriesLog(ExerciseLog exerciseLog, Integer reps, Float weight);

    SeriesLogResponse getSeriesLogResponse(Long seriesId);

    void deleteSeriesLog(SeriesLog seriesLog);

    SeriesLog getSeriesLog(Long seriesId);
}
