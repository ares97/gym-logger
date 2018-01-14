package slowinski.radoslaw.gymlogger.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import slowinski.radoslaw.gymlogger.exception.ForbiddenDataAccessException;
import slowinski.radoslaw.gymlogger.handlers.ExerciseLogAccessHandler;
import slowinski.radoslaw.gymlogger.handlers.TrainingLogAccessHandler;
import slowinski.radoslaw.gymlogger.workout.entity.ExerciseLog;
import slowinski.radoslaw.gymlogger.workout.entity.TrainingLog;

@Aspect
@Component
public class ExerciseLogAccessAspect {

    @Autowired
    ExerciseLogAccessHandler exerciseLogAccessHandler;
    @Autowired
    TrainingLogAccessHandler trainingLogAccessHandler;

    @Before("execution(* slowinski.radoslaw.gymlogger.workout.service.TrainingFacade.getExerciseLogResponse(Long)) && args(exerciseId)")
    public void authoriseGetExerciseLog(Long exerciseId) {
        if (!exerciseLogAccessHandler.canAccessExerciseLog(exerciseId))
            throw new ForbiddenDataAccessException();
    }

    @Before("execution(* slowinski.radoslaw.gymlogger.workout.service.TrainingFacade.deleteExerciseLog(..)) && args(exerciseLog)")
    public void authoriseDeleteExerciseLog(ExerciseLog exerciseLog) {
        if (!exerciseLogAccessHandler.canAccessExerciseLog(exerciseLog.getId()))
            throw new ForbiddenDataAccessException();
    }

    @Before("execution(* slowinski.radoslaw.gymlogger.workout.service.TrainingFacade.createExerciseLog(..)) && args(..,trainingLog)")
    public void authoriseCreateExerciseLog(TrainingLog trainingLog) {
        if (!trainingLogAccessHandler.canAccessTrainingLog(trainingLog.getId()))
            throw new ForbiddenDataAccessException();
    }


}
