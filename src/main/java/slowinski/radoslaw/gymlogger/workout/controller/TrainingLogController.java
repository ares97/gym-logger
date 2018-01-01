package slowinski.radoslaw.gymlogger.workout.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import slowinski.radoslaw.gymlogger.utilities.ApiMappings;
import slowinski.radoslaw.gymlogger.workout.entity.ExerciseLog;
import slowinski.radoslaw.gymlogger.workout.entity.TrainingLog;
import slowinski.radoslaw.gymlogger.workout.service.TrainingLogService;

import java.time.LocalDate;
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

    @PostMapping("/{trainingLog}")
    public void addExerciseLogToTrainingLog(@PathVariable TrainingLog trainingLog, @RequestBody ExerciseLog exerciseLog) {
        trainingLogService.addExerciseLogToTrainingLog(trainingLog, exerciseLog);
    }

    @PostMapping
    public void addEmptyTrainingLog(@RequestParam LocalDate trainingDate) {
        trainingLogService.addEmptyTrainingLog(trainingDate);
    }
}
