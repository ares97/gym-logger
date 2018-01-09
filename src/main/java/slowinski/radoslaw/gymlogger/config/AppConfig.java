package slowinski.radoslaw.gymlogger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import slowinski.radoslaw.gymlogger.workout.service.TrainingFacade;
import slowinski.radoslaw.gymlogger.workout.service.impl.TrainingFacadeImpl;

@Configuration
public class AppConfig {

    @Bean
    public TrainingFacade trainingFacade() {
        return new TrainingFacadeImpl();
    }
}
