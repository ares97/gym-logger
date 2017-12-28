package slowinski.radoslaw.gymlogger.workout.service;

import slowinski.radoslaw.gymlogger.workout.entity.ExerciseLog;
import slowinski.radoslaw.gymlogger.workout.entity.SeriesLog;

public interface SeriesLogService {
    void addSeries(SeriesLog seriesLog, ExerciseLog exerciseLog);
}
