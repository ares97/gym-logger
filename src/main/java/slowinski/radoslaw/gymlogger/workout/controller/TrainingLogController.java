package slowinski.radoslaw.gymlogger.workout.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import slowinski.radoslaw.gymlogger.utilities.ApiMappings;
import slowinski.radoslaw.gymlogger.workout.entity.TrainingLog;
import slowinski.radoslaw.gymlogger.workout.service.TrainingLogService;

import java.util.List;

@RestController
@RequestMapping(ApiMappings.TRAINING_LOG_V1)
public class TrainingLogController {

    @Autowired
    TrainingLogService trainingLogService;

    @GetMapping
    public List<TrainingLog> getTrainingLogs() {
        return trainingLogService.getTrainingLogs();
    }

}
