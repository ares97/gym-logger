package slowinski.radoslaw.gymlogger.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import slowinski.radoslaw.gymlogger.exception.ForbiddenDataAccessException;
import slowinski.radoslaw.gymlogger.user.service.UserService;
import slowinski.radoslaw.gymlogger.workout.entity.ExerciseLog;
import slowinski.radoslaw.gymlogger.workout.entity.SeriesLog;
import slowinski.radoslaw.gymlogger.workout.entity.TrainingLog;
import slowinski.radoslaw.gymlogger.workout.service.ExerciseLogService;
import slowinski.radoslaw.gymlogger.workout.service.SeriesLogService;
import slowinski.radoslaw.gymlogger.workout.service.TrainingLogService;

@Aspect
@Configuration
public class AuthenticationAspect {

    @Autowired
    private UserService userService;
    @Autowired
    private TrainingLogService trainingLogService;
    @Autowired
    private ExerciseLogService exerciseLogService;
    @Autowired
    private SeriesLogService seriesLogService;

    @Before("execution(* slowinski.radoslaw.gymlogger.workout.service.TrainingLogService.getTrainingLogResponse(Long)) && args(trainingId)")
    public void authoriseTrainingLog(Long trainingId) {
        Long userId = userService.getCurrentUser().getId();
        TrainingLog trainingLog = trainingLogService.getTrainingLog(trainingId);

        if (!trainingLog.getUser().getId().equals(userId))
            throw new ForbiddenDataAccessException();
    }

    @Before("execution(* slowinski.radoslaw.gymlogger.workout.service.ExerciseLogService.getExerciseLogResponse(Long)) && args(exerciseId)")
    public void authoriseExerciseLog(Long exerciseId) {
        Long userId = userService.getCurrentUser().getId();
        ExerciseLog exerciseLog = exerciseLogService.getExerciseLog(exerciseId);
        Long exerciseOwnerId = exerciseLog.getTrainingLog().getUser().getId();

        if (!exerciseOwnerId.equals(userId))
            throw new ForbiddenDataAccessException();
    }

    @Before("execution(* slowinski.radoslaw.gymlogger.workout.service.SeriesLogService.getSeriesLogResponse(Long)) && args(seriesId)")
    public void authoriseSeriesLog(Long seriesId) {
        Long userId = userService.getCurrentUser().getId();
        SeriesLog seriesLog = seriesLogService.getSeriesLog(seriesId);
        Long seriesOwnerId = seriesLog.getExerciseLog().getTrainingLog().getUser().getId();

        if (!seriesOwnerId.equals(userId))
            throw new ForbiddenDataAccessException();
    }
}
