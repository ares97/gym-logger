package slowinski.radoslaw.gymlogger.user.service;

import slowinski.radoslaw.gymlogger.user.entity.User;

import java.util.List;

public interface UserService {
    void save(User user);

    User findByUsername(String username);

    List<User> findAll();

}
