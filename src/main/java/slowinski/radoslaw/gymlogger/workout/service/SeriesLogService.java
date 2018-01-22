package slowinski.radoslaw.gymlogger.workout.service;

import slowinski.radoslaw.gymlogger.workout.entity.SeriesLog;
import slowinski.radoslaw.gymlogger.workout.model.response.SeriesLogResponse;

public interface SeriesLogService {

    SeriesLogResponse createSeriesLog(Long exerciseLog, Integer reps, Float weight);

    SeriesLogResponse getSeriesLogResponse(Long seriesId);

    void deleteSeriesLog(Long seriesLog);

    SeriesLog getSeriesLog(Long seriesId);
}
