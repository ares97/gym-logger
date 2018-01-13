package slowinski.radoslaw.gymlogger.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import slowinski.radoslaw.gymlogger.user.entity.User;
import slowinski.radoslaw.gymlogger.user.repository.UserRepository;
import slowinski.radoslaw.gymlogger.workout.model.response.TrainingLogResponse;

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
    ConversionService conversionService;

    @Autowired
    Authentication authentication;

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.saveAndFlush(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void saveUserIfValid(User user) {
        if (usernameExists(user.getUsername())) {
            userRepository.save(user);
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

    private boolean usernameExists(String username) {
        return Optional.ofNullable(userRepository.findByUsername(username)).isPresent();
    }
}
