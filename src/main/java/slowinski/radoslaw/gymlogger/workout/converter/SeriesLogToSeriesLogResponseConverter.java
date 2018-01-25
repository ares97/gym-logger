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

        Links linksToResponse = getLinksToResponse(source.getId());
        seriesLogResponse.setLinks(linksToResponse);

        return seriesLogResponse;
    }

    private Links getLinksToResponse(Long seriesId) {
        Links links = new Links();
        Self self = new Self();
        self.setRef(ApiMappings.API_LOGS +
                ApiMappings.API_GET_SERIES.replace("{seriesLogId}", seriesId.toString()));

        links.setSelf(self);
        return links;
    }

}
