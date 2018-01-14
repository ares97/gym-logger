package slowinski.radoslaw.gymlogger.workout.converter;

import org.springframework.core.convert.converter.Converter;
import slowinski.radoslaw.gymlogger.utilities.ApiMappings;
import slowinski.radoslaw.gymlogger.workout.entity.ExerciseLog;
import slowinski.radoslaw.gymlogger.workout.entity.SeriesLog;
import slowinski.radoslaw.gymlogger.workout.model.Links;
import slowinski.radoslaw.gymlogger.workout.model.Self;
import slowinski.radoslaw.gymlogger.workout.model.response.ExerciseLogResponse;
import slowinski.radoslaw.gymlogger.workout.model.response.SeriesLogResponse;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ExerciseLogToExerciseLogResponseConverter implements Converter<ExerciseLog, ExerciseLogResponse> {


    @Override
    public ExerciseLogResponse convert(ExerciseLog source) {
        ExerciseLogResponse exerciseLogResponse = new ExerciseLogResponse();
        exerciseLogResponse.setId(source.getId());
        exerciseLogResponse.setTrainingLogId(source.getTrainingLog().getId());
        exerciseLogResponse.setExerciseTitle(source.getExerciseTitle());

        Links linksToResponse = getLinksToResponse(source.getId(), source.getTrainingLog().getId());
        exerciseLogResponse.setLinks(linksToResponse);

        exerciseLogResponse.setSeriesLogs(
                Optional.ofNullable(
                        source.getSeriesLogs()).
                        map(this::convertIntoSeriesLogResponse).
                        orElse(Collections.emptyList()));

        return exerciseLogResponse;
    }

    private List<SeriesLogResponse> convertIntoSeriesLogResponse(List<SeriesLog> seriesLogs) {
        SeriesLogToSeriesLogResponseConverter converter = new SeriesLogToSeriesLogResponseConverter();

        return seriesLogs.
                stream().
                map(converter::convert).
                collect(Collectors.toList());

    }

    private Links getLinksToResponse(Long exerciseId, Long trainingId) {
        Links links = new Links();
        Self self = new Self();
        self.setRef(ApiMappings.LOGS_V1 + ApiMappings.EXERCISE_LOG_MAPPING.
                replace("{trainingLog}", trainingId.toString()) + "/" + exerciseId);

        links.setSelf(self);
        return links;
    }
}
