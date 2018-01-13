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
import java.util.Collections;
import java.util.List;
import java.util.Optional;
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
        User user = userRepository.findByUsername(authentication.getName());

        return Optional.ofNullable(user).
                map(u -> u.getTrainingLogs().
                        stream().
                        map(t -> conversionService.convert(t, TrainingLogResponse.class)).
                        collect(Collectors.toList())).
                orElse(Collections.emptyList());
    }

    @Override
    public void logoutUser(HttpServletRequest request, HttpServletResponse response) {
        Optional.ofNullable(authentication).
                ifPresent(x -> new SecurityContextLogoutHandler().logout(request, response, x));
    }

    private boolean usernameExists(String username) {
        return userRepository.findByUsername(username) != null;
    }

    private void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.saveAndFlush(user);
    }
}
