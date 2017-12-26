package slowinski.radoslaw.gymlogger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import slowinski.radoslaw.gymlogger.exercise.entity.Exercise;
import slowinski.radoslaw.gymlogger.exercise.repository.ExerciseRepository;
import slowinski.radoslaw.gymlogger.user.entity.User;
import slowinski.radoslaw.gymlogger.user.service.UserService;

@SpringBootApplication
public class GymLoggerApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(GymLoggerApplication.class, args);
    }

    @Autowired
    UserService userService;
    @Autowired
    ExerciseRepository exerciseRepository;

    @Override
    public void run(String... args) {
        User user = new User("admin", "password", "ROLE_USER");
        userService.save(user);

        Exercise exercise = new Exercise();
        exercise.setDescription("description...");
        exercise.setTitle("Military Press");
        exerciseRepository.save(exercise);
    }
}
