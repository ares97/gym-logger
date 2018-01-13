package slowinski.radoslaw.gymlogger.user.service;

import slowinski.radoslaw.gymlogger.user.entity.User;
import slowinski.radoslaw.gymlogger.workout.model.response.TrainingLogResponse;

import java.util.List;

public interface UserService {
    void save(User user);

    List<User> findAll();

    void saveUserIfValid(User user);

    List<TrainingLogResponse> getTrainingLogs();
}
