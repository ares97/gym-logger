package slowinski.radoslaw.gymlogger.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import slowinski.radoslaw.gymlogger.exception.ForbiddenDataAccessException;
import slowinski.radoslaw.gymlogger.handlers.TrainingLogAccessHandler;
import slowinski.radoslaw.gymlogger.workout.entity.TrainingLog;

@Aspect
@Component
class TrainingLogAccessAspect {

    @Autowired
    private TrainingLogAccessHandler trainingLogAccessHandler;

    @Before("execution(* slowinski.radoslaw.gymlogger.workout.service.TrainingFacade.getTrainingLogResponse(Long)) && args(trainingId)")
    public void authoriseGetTrainingLog(Long trainingId) {
        if (!trainingLogAccessHandler.canAccessTrainingLog(trainingId))
            throw new ForbiddenDataAccessException();
    }

    @Before("execution(* slowinski.radoslaw.gymlogger.workout.service.TrainingFacade.deleteTrainingLog(..)) && args(trainingLog)")
    public void authoriseDeleteTrainingLog(TrainingLog trainingLog) {
        if (!trainingLogAccessHandler.canAccessTrainingLog(trainingLog.getId()))
            throw new ForbiddenDataAccessException();
    }

}
