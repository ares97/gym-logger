package slowinski.radoslaw.gymlogger.user.service;

import slowinski.radoslaw.gymlogger.user.entity.User;
import slowinski.radoslaw.gymlogger.workout.model.response.TrainingLogResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface UserService {

    void saveUserIfValid(User user);

    void logoutUser(HttpServletRequest request, HttpServletResponse response);

    List<TrainingLogResponse> getTrainingLogs();

    User getCurrentUser();

    Long getCurrentUserId();
}
