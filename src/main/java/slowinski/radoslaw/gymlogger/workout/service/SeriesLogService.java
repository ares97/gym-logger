package slowinski.radoslaw.gymlogger.workout.service;

import slowinski.radoslaw.gymlogger.workout.entity.ExerciseLog;

public interface SeriesLogService {

    void addSeries(ExerciseLog exerciseLog, Integer reps, Float weight);
}
