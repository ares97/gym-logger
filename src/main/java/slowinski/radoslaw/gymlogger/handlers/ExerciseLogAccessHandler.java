package slowinski.radoslaw.gymlogger.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import slowinski.radoslaw.gymlogger.user.service.UserService;
import slowinski.radoslaw.gymlogger.workout.entity.ExerciseLog;
import slowinski.radoslaw.gymlogger.workout.service.ExerciseLogService;

@Component
public class ExerciseLogAccessHandler {

    @Autowired
    ExerciseLogService exerciseLogService;
    @Autowired
    private UserService userService;

    public boolean canAccessExerciseLog(Long exerciseId) {
        ExerciseLog exerciseLog = exerciseLogService.getExerciseLog(exerciseId);
        Long exerciseOwnerId = exerciseLog.getTrainingLog().getUser().getId();

        return exerciseOwnerId.equals(userService.getCurrentUserId());
    }
}
