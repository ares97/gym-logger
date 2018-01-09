package slowinski.radoslaw.gymlogger;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import slowinski.radoslaw.gymlogger.user.entity.User;
import slowinski.radoslaw.gymlogger.user.service.UserService;
import slowinski.radoslaw.gymlogger.workout.entity.ExerciseLog;
import slowinski.radoslaw.gymlogger.workout.entity.SeriesLog;
import slowinski.radoslaw.gymlogger.workout.entity.TrainingLog;
import slowinski.radoslaw.gymlogger.workout.repository.ExerciseLogRepository;
import slowinski.radoslaw.gymlogger.workout.repository.SeriesLogRepository;
import slowinski.radoslaw.gymlogger.workout.repository.TrainingLogRepository;

import java.time.LocalDate;
import java.util.Arrays;

@SpringBootApplication
public class GymLoggerApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(GymLoggerApplication.class, args);
    }

    @Autowired
    UserService userService;
    @Autowired
    ExerciseLogRepository exerciseLogRepository;
    @Autowired
    SeriesLogRepository seriesLogRepository;
    @Autowired
    TrainingLogRepository trainingLogRepository;

    @Override
    public void run(String... args) {
        User user = new User("user", "test", "ROLE_USER");
        userService.save(user);

        ExerciseLog exerciseLog = new ExerciseLog();
        exerciseLog.setExerciseTitle("bench press");

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

        TrainingLog trainingLog = new TrainingLog();
        trainingLog.setTrainingDate(LocalDate.now());
        trainingLog.setExerciseLogs(Arrays.asList(exerciseLog));
        trainingLogRepository.save(trainingLog);

    }
}
