package slowinski.radoslaw.gymlogger.workout.converter;

import org.springframework.core.convert.converter.Converter;
import slowinski.radoslaw.gymlogger.utilities.ApiMappings;
import slowinski.radoslaw.gymlogger.workout.entity.ExerciseLog;
import slowinski.radoslaw.gymlogger.workout.entity.TrainingLog;
import slowinski.radoslaw.gymlogger.workout.model.Links;
import slowinski.radoslaw.gymlogger.workout.model.Self;
import slowinski.radoslaw.gymlogger.workout.model.response.ExerciseLogResponse;
import slowinski.radoslaw.gymlogger.workout.model.response.TrainingLogResponse;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class TrainingLogToTrainingLogResponseConverter implements Converter<TrainingLog, TrainingLogResponse> {


    @Override
    public TrainingLogResponse convert(TrainingLog source) {
        TrainingLogResponse trainingLogResponse = new TrainingLogResponse();
        trainingLogResponse.setId(source.getId());
        trainingLogResponse.setLinks(getLinksToResponse(source.getId()));
        trainingLogResponse.setTrainingDate(source.getTrainingDate());

        Optional.ofNullable(source.getExerciseLogs()).ifPresentOrElse(
                x -> {
                    List<ExerciseLogResponse> exerciseLogResponses = convertIntoExerciseLogResponse(x);
                    trainingLogResponse.setExerciseLogs(exerciseLogResponses);
                },
                () -> trainingLogResponse.setExerciseLogs(new LinkedList<>())
        );

        return trainingLogResponse;
    }

    private List<ExerciseLogResponse> convertIntoExerciseLogResponse(List<ExerciseLog> exerciseLogs) {
        List<ExerciseLogResponse> responseLogs = new LinkedList<>();
        ExerciseLogToExerciseLogResponseConverter converter = new ExerciseLogToExerciseLogResponseConverter();
        for (ExerciseLog log : exerciseLogs) {
            responseLogs.add(converter.convert(log));
        }

        return responseLogs;
    }

    private Links getLinksToResponse(Long id) {
        Links links = new Links();
        Self self = new Self();
        self.setRef(ApiMappings.LOGS_V1 + ApiMappings.TRAINING_LOG_MAPPING + "/" + id);
        links.setSelf(self);
        return links;
    }
}
