package slowinski.radoslaw.gymlogger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import slowinski.radoslaw.gymlogger.workout.converter.ExerciseLogToExerciseLogResponseConverter;
import slowinski.radoslaw.gymlogger.workout.converter.SeriesLogToSeriesLogResponseConverter;
import slowinski.radoslaw.gymlogger.workout.converter.TrainingLogToTrainingLogResponseConverter;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class ConversionConfig {

    private Set<Converter> getConverters() {
        Set<Converter> converters = new HashSet<>();
        converters.add(new TrainingLogToTrainingLogResponseConverter());
        converters.add(new ExerciseLogToExerciseLogResponseConverter());
        converters.add(new SeriesLogToSeriesLogResponseConverter());

        return converters;
    }

    @Bean
    public ConversionService conversionService() {
        ConversionServiceFactoryBean bean = new ConversionServiceFactoryBean();
        bean.setConverters(getConverters());
        bean.afterPropertiesSet();

        return bean.getObject();
    }
}
