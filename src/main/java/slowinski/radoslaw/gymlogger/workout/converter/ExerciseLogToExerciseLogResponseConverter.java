package slowinski.radoslaw.gymlogger.workout.converter;

import org.springframework.core.convert.converter.Converter;
import slowinski.radoslaw.gymlogger.utilities.ApiMappings;
import slowinski.radoslaw.gymlogger.workout.entity.ExerciseLog;
import slowinski.radoslaw.gymlogger.workout.entity.SeriesLog;
import slowinski.radoslaw.gymlogger.workout.model.Links;
import slowinski.radoslaw.gymlogger.workout.model.Self;
import slowinski.radoslaw.gymlogger.workout.model.response.ExerciseLogResponse;
import slowinski.radoslaw.gymlogger.workout.model.response.SeriesLogResponse;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class ExerciseLogToExerciseLogResponseConverter implements Converter<ExerciseLog, ExerciseLogResponse> {


    @Override
    public ExerciseLogResponse convert(ExerciseLog source) {
        ExerciseLogResponse exerciseLogResponse = new ExerciseLogResponse();
        exerciseLogResponse.setId(source.getId());
        exerciseLogResponse.setExerciseTitle(source.getExerciseTitle());
        exerciseLogResponse.setLinks(getLinksToResponse(source.getId()));

        if (Optional.ofNullable(source.getSeriesLogs()).isPresent()) {
            List<SeriesLogResponse> seriesLogResponses = convertIntoSeriesLogResponse((source.getSeriesLogs()));
            exerciseLogResponse.setSeriesLogs(seriesLogResponses);
        } else
            exerciseLogResponse.setSeriesLogs(new LinkedList<>());
        return exerciseLogResponse;
    }

    private List<SeriesLogResponse> convertIntoSeriesLogResponse(List<SeriesLog> seriesLogs) {
        List<SeriesLogResponse> responseLogs = new LinkedList<>();
        SeriesLogToSeriesLogResponseConverter converter = new SeriesLogToSeriesLogResponseConverter();
        for (SeriesLog log : seriesLogs) {
            responseLogs.add(converter.convert(log));
        }


        return responseLogs;
    }

    private Links getLinksToResponse(Long id) {
        Links links = new Links();
        Self self = new Self();
        self.setRef(ApiMappings.LOGS_V1 + ApiMappings.EXERCISE_LOG_MAPPING + "/" + id);
        links.setSelf(self);
        return links;
    }
}
