package slowinski.radoslaw.gymlogger.exercise.service;

import slowinski.radoslaw.gymlogger.exercise.entity.ExerciseLog;
import slowinski.radoslaw.gymlogger.exercise.entity.SeriesLog;

public interface SeriesLogService {
    void addSeries(SeriesLog seriesLog, ExerciseLog exerciseLog);
}
