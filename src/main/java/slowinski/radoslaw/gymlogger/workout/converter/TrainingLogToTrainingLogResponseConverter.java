package slowinski.radoslaw.gymlogger.workout.converter;

import org.springframework.core.convert.converter.Converter;
import slowinski.radoslaw.gymlogger.utilities.ApiMappings;
import slowinski.radoslaw.gymlogger.workout.entity.ExerciseLog;
import slowinski.radoslaw.gymlogger.workout.entity.TrainingLog;
import slowinski.radoslaw.gymlogger.workout.model.Links;
import slowinski.radoslaw.gymlogger.workout.model.Self;
import slowinski.radoslaw.gymlogger.workout.model.response.ExerciseLogResponse;
import slowinski.radoslaw.gymlogger.workout.model.response.TrainingLogResponse;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TrainingLogToTrainingLogResponseConverter implements Converter<TrainingLog, TrainingLogResponse> {


    @Override
    public TrainingLogResponse convert(TrainingLog source) {
        TrainingLogResponse trainingLogResponse = new TrainingLogResponse();
        trainingLogResponse.setId(source.getId());
        trainingLogResponse.setLinks(getLinksToResponse(source.getId()));
        trainingLogResponse.setTrainingDate(source.getTrainingDate());

        trainingLogResponse.setExerciseLogs(
                Optional.ofNullable(
                        source.getExerciseLogs()).
                        map(this::convertIntoExerciseLogResponse).
                        orElse(Collections.emptyList()));


        return trainingLogResponse;
    }

    private List<ExerciseLogResponse> convertIntoExerciseLogResponse(List<ExerciseLog> exerciseLogs) {
        ExerciseLogToExerciseLogResponseConverter converter = new ExerciseLogToExerciseLogResponseConverter();

        return exerciseLogs.
                stream().
                map(converter::convert).
                collect(Collectors.toList());
    }

    private Links getLinksToResponse(Long id) {
        Links links = new Links();
        Self self = new Self();
        self.setRef(ApiMappings.API_LOGS +
                ApiMappings.API_GET_TRAINING.replace("{trainingLogId}", id.toString()));

        links.setSelf(self);
        return links;
    }
}
