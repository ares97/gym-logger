package slowinski.radoslaw.gymlogger.workout.converter;

import org.springframework.core.convert.converter.Converter;
import slowinski.radoslaw.gymlogger.utilities.ApiMappings;
import slowinski.radoslaw.gymlogger.workout.entity.TrainingLog;
import slowinski.radoslaw.gymlogger.workout.model.Links;
import slowinski.radoslaw.gymlogger.workout.model.Self;
import slowinski.radoslaw.gymlogger.workout.model.response.TrainingLogResponse;

public class TrainingLogToTrainingLogResponseConverter implements Converter<TrainingLog, TrainingLogResponse> {

    @Override
    public TrainingLogResponse convert(TrainingLog source) {
        TrainingLogResponse trainingLogResponse = new TrainingLogResponse();
        trainingLogResponse.setId(source.getId());
        trainingLogResponse.setExerciseLogs(source.getExerciseLogs());
        trainingLogResponse.setTrainingDate(source.getTrainingDate());

        Links links = new Links();
        Self self = new Self();
        self.setRef(ApiMappings.LOGS_V1 + ApiMappings.TRAINING_LOG_MAPPING + "/" + trainingLogResponse.getId());
        links.setSelf(self);

        trainingLogResponse.setLinks(links);

        return trainingLogResponse;
    }
}
