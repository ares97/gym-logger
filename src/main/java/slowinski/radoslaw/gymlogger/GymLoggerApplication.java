package slowinski.radoslaw.gymlogger;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import slowinski.radoslaw.gymlogger.exercise.entity.Exercise;
import slowinski.radoslaw.gymlogger.exercise.entity.ExerciseLog;
import slowinski.radoslaw.gymlogger.exercise.entity.SeriesLog;
import slowinski.radoslaw.gymlogger.exercise.repository.ExerciseLogRepository;
import slowinski.radoslaw.gymlogger.exercise.repository.ExerciseRepository;
import slowinski.radoslaw.gymlogger.exercise.repository.SeriesLogRepository;
import slowinski.radoslaw.gymlogger.user.entity.User;
import slowinski.radoslaw.gymlogger.user.service.UserService;

import java.util.Arrays;

@SpringBootApplication
public class GymLoggerApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(GymLoggerApplication.class, args);
    }

    @Autowired
    UserService userService;
    @Autowired
    ExerciseRepository exerciseRepository;
    @Autowired
    ExerciseLogRepository exerciseLogRepository;
    @Autowired
    SeriesLogRepository seriesLogRepository;
    @Override
    public void run(String... args) {
        User user = new User("admin", "password", "ROLE_USER");
        userService.save(user);

        Exercise exercise = new Exercise();
        exercise.setDescription("description...");
        exercise.setTitle("Military Press");
        exerciseRepository.save(exercise);

        ExerciseLog exerciseLog = new ExerciseLog();
        exerciseLog.setExercise(exercise);

        SeriesLog seriesLog = new SeriesLog();
        seriesLog.setReps(5);
        seriesLog.setWeight(92.5f);
        SeriesLog seriesLog2 = new SeriesLog();
        seriesLog2.setReps(4);
        seriesLog2.setWeight(95.0f);
        seriesLogRepository.save(seriesLog);
        seriesLogRepository.save(seriesLog2);
        
        exerciseLog.setSeriesLogs(Arrays.asList(seriesLog, seriesLog2));
        exerciseLogRepository.save(exerciseLog);


    }
}
