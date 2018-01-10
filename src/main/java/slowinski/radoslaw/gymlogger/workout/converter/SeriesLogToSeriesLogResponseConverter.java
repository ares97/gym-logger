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
        seriesLogResponse.setLinks(getLinksToResponse(source.getId()));

        return seriesLogResponse;
    }

    private Links getLinksToResponse(Long id) {
        Links links = new Links();
        Self self = new Self();
        self.setRef(ApiMappings.LOGS_V1 + ApiMappings.SERIES_LOG_MAPPING + "/" + id);
        links.setSelf(self);
        return links;
    }

}
