package slowinski.radoslaw.gymlogger.workout.service;

import slowinski.radoslaw.gymlogger.workout.entity.ExerciseLog;
import slowinski.radoslaw.gymlogger.workout.entity.SeriesLog;
import slowinski.radoslaw.gymlogger.workout.model.response.SeriesLogResponse;

public interface SeriesLogService {

    SeriesLogResponse addSeries(ExerciseLog exerciseLog, Integer reps, Float weight);

    SeriesLogResponse getSeriesLog(Long seriesId);

    void deleteSeriesLog(SeriesLog seriesLog);
}
