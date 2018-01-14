package slowinski.radoslaw.gymlogger.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Service;
import slowinski.radoslaw.gymlogger.user.entity.User;
import slowinski.radoslaw.gymlogger.user.repository.UserRepository;
import slowinski.radoslaw.gymlogger.workout.model.response.TrainingLogResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private ConversionService conversionService;

    @Autowired
    private Authentication authentication;

    @Override
    public void saveUserIfValid(User user) {
        if (!usernameExists(user.getUsername())) {
            save(user);
        }
    }

    @Override
    public List<TrainingLogResponse> getTrainingLogs() {
        return getCurrentUser().getTrainingLogs().
                stream().
                map(t -> conversionService.convert(t, TrainingLogResponse.class)).
                collect(Collectors.toList());
    }

    @Override
    public User getCurrentUser() {
        return userRepository.findByUsername(authentication.getName());
    }

    @Override
    public Long getCurrentUserId() {
        return getCurrentUser().getId();
    }

    @Override
    public void logoutUser(HttpServletRequest request, HttpServletResponse response) {
        if (authentication != null) {
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }
    }

    private boolean usernameExists(String username) {
        return userRepository.findByUsername(username) != null;
    }

    private void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.saveAndFlush(user);
    }
}
