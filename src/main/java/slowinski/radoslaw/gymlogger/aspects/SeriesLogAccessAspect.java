package slowinski.radoslaw.gymlogger.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import slowinski.radoslaw.gymlogger.exception.ForbiddenDataAccessException;
import slowinski.radoslaw.gymlogger.handlers.ExerciseLogAccessHandler;
import slowinski.radoslaw.gymlogger.handlers.SeriesLogAccessHandler;
import slowinski.radoslaw.gymlogger.workout.entity.ExerciseLog;
import slowinski.radoslaw.gymlogger.workout.entity.SeriesLog;

@Aspect
@Component
class SeriesLogAccessAspect {

    @Autowired
    SeriesLogAccessHandler seriesLogAccessHandler;
    @Autowired
    ExerciseLogAccessHandler exerciseLogAccessHandler;

    @Before("execution(* slowinski.radoslaw.gymlogger.workout.service.TrainingFacade.getSeriesLogResponse(..)) && args(seriesId)")
    public void authoriseGetSeriesLog(Long seriesId) {
        if (!seriesLogAccessHandler.canAccessSeriesLog(seriesId))
            throw new ForbiddenDataAccessException();
    }

    @Before("execution(* slowinski.radoslaw.gymlogger.workout.service.TrainingFacade.deleteSeriesLog(..)) && args(seriesLog)")
    public void authoriseDeleteSeriesLog(SeriesLog seriesLog) {
        if (!seriesLogAccessHandler.canAccessSeriesLog(seriesLog.getId()))
            throw new ForbiddenDataAccessException();
    }

    @Before("execution(* slowinski.radoslaw.gymlogger.workout.service.TrainingFacade.createSeriesLog(..)) && args(exerciseLog,..)")
    public void authoriseAddSeriesLog(ExerciseLog exerciseLog) {
        if (!exerciseLogAccessHandler.canAccessExerciseLog(exerciseLog.getId()))
            throw new ForbiddenDataAccessException();
    }
}
