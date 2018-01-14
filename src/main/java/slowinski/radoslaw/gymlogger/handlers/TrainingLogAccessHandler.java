package slowinski.radoslaw.gymlogger.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import slowinski.radoslaw.gymlogger.user.service.UserService;
import slowinski.radoslaw.gymlogger.workout.entity.TrainingLog;
import slowinski.radoslaw.gymlogger.workout.service.TrainingLogService;

@Component
public class TrainingLogAccessHandler {

    @Autowired
    private UserService userService;
    @Autowired
    private TrainingLogService trainingLogService;


    public boolean canAccessTrainingLog(Long trainingId) {
        TrainingLog trainingLog = trainingLogService.getTrainingLog(trainingId);
        Long trainingOwnerId = trainingLog.getUser().getId();

        return trainingOwnerId.equals(userService.getCurrentUserId());
    }


}
