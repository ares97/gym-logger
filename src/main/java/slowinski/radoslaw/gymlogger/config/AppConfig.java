package slowinski.radoslaw.gymlogger.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
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

    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        return objectMapper;
    }

    @Bean
    public ObjectWriter objectWriter() {
        return objectMapper().writerWithDefaultPrettyPrinter();
    }
}
