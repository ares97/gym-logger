package slowinski.radoslaw.gymlogger.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import slowinski.radoslaw.gymlogger.user.service.UserService;
import slowinski.radoslaw.gymlogger.workout.entity.SeriesLog;
import slowinski.radoslaw.gymlogger.workout.service.SeriesLogService;

@Component
public class SeriesLogAccessHandler {

    @Autowired
    UserService userService;
    @Autowired
    private SeriesLogService seriesLogService;

    public boolean canAccessSeriesLog(Long seriesId) {
        SeriesLog seriesLog = seriesLogService.getSeriesLog(seriesId);
        Long seriesOwnerId = seriesLog.getExerciseLog().getTrainingLog().getUser().getId();

        return seriesOwnerId.equals(userService.getCurrentUserId());
    }
}
