package slowinski.radoslaw.gymlogger.workout.converter;

import org.springframework.core.convert.converter.Converter;
import slowinski.radoslaw.gymlogger.utilities.ApiMappings;
import slowinski.radoslaw.gymlogger.workout.entity.SeriesLog;
import slowinski.radoslaw.gymlogger.workout.model.Links;
import slowinski.radoslaw.gymlogger.workout.model.Self;
import slowinski.radoslaw.gymlogger.workout.model.response.SeriesLogResponse;

public class SeriesLogToSeriesLogResponseConverter implements Converter<SeriesLog, SeriesLogResponse> {


    @Override
    public SeriesLogResponse convert(SeriesLog source) {
        SeriesLogResponse seriesLogResponse = new SeriesLogResponse();
        seriesLogResponse.setId(source.getId());
        seriesLogResponse.setReps(source.getReps());
        seriesLogResponse.setWeight(source.getWeight());
        seriesLogResponse.setExerciseLogId(source.getExerciseLog().getId());
        Links linksToResponse = getLinksToResponse(source.getId(), source.getExerciseLog().getId(), source.getExerciseLog().getTrainingLog().getId());
        seriesLogResponse.setLinks(linksToResponse);

        return seriesLogResponse;
    }

    private Links getLinksToResponse(Long seriesId, Long exerciseId, Long trainingId) {
        Links links = new Links();
        Self self = new Self();
        self.setRef(ApiMappings.LOGS_V1 + ApiMappings.SERIES_LOG_MAPPING.
                replace("{trainingLog}", trainingId.toString()).
                replace("{exerciseLog}", exerciseId.toString()) +
                "/" + seriesId);

        links.setSelf(self);
        return links;
    }

}
