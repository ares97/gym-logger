package slowinski.radoslaw.gymlogger.exercise.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import slowinski.radoslaw.gymlogger.exercise.entity.ExerciseLog;
import slowinski.radoslaw.gymlogger.exercise.entity.SeriesLog;
import slowinski.radoslaw.gymlogger.exercise.repository.SeriesLogRepository;
import slowinski.radoslaw.gymlogger.exercise.service.ExerciseLogService;
import slowinski.radoslaw.gymlogger.exercise.service.SeriesLogService;

@Service
public class SeriesLogServiceImpl implements SeriesLogService {

    @Autowired
    SeriesLogRepository seriesLogRepository;

    @Autowired
    ExerciseLogService exerciseLogService;

    @Override
    public void addSeries(SeriesLog seriesLog, ExerciseLog exerciseLog) {
        seriesLogRepository.save(seriesLog);
        addSeriesToExerciseLog(seriesLog, exerciseLog);
    }

    private void addSeriesToExerciseLog(SeriesLog seriesLog, ExerciseLog exerciseLog) {
        exerciseLog.getSeriesLogs().add(seriesLog);
        exerciseLogService.updateExerciseLog(exerciseLog);
    }
}
