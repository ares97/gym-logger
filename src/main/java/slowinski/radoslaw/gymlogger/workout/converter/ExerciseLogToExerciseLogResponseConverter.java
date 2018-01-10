package slowinski.radoslaw.gymlogger.workout.converter;

import org.springframework.core.convert.converter.Converter;
import slowinski.radoslaw.gymlogger.utilities.ApiMappings;
import slowinski.radoslaw.gymlogger.workout.entity.ExerciseLog;
import slowinski.radoslaw.gymlogger.workout.model.Links;
import slowinski.radoslaw.gymlogger.workout.model.Self;
import slowinski.radoslaw.gymlogger.workout.model.response.ExerciseLogResponse;

public class ExerciseLogToExerciseLogResponseConverter implements Converter<ExerciseLog, ExerciseLogResponse> {


    @Override
    public ExerciseLogResponse convert(ExerciseLog source) {
        ExerciseLogResponse exerciseLogResponse = new ExerciseLogResponse();
        exerciseLogResponse.setId(source.getId());
        exerciseLogResponse.setExerciseTitle(source.getExerciseTitle());
        exerciseLogResponse.setSeriesLogs(source.getSeriesLogs());

        Links links = new Links();
        Self self = new Self();
        self.setRef(ApiMappings.LOGS_V1 + ApiMappings.EXERCISE_LOG_MAPPING + "/" + exerciseLogResponse.getId());
        links.setSelf(self);

        exerciseLogResponse.setLinks(links);

        return exerciseLogResponse;
    }
}
