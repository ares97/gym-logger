package slowinski.radoslaw.gymlogger.workout.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import slowinski.radoslaw.gymlogger.utilities.ApiMappings;
import slowinski.radoslaw.gymlogger.workout.model.response.ExerciseLogResponse;
import slowinski.radoslaw.gymlogger.workout.model.response.SeriesLogResponse;
import slowinski.radoslaw.gymlogger.workout.model.response.TrainingLogResponse;
import slowinski.radoslaw.gymlogger.workout.service.TrainingFacade;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(ApiMappings.LOGS_V1)
class TrainingController {

    @Autowired
    TrainingFacade trainingFacade;

    @PostMapping(ApiMappings.TRAINING_LOG_MAPPING)
    public ResponseEntity<TrainingLogResponse> createAndGetTrainingLog(
            @RequestParam(name = "date")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @Valid LocalDate localDate) {

        TrainingLogResponse logResponse = trainingFacade.createTrainingLog(localDate);
        return new ResponseEntity<>(logResponse, HttpStatus.CREATED);
    }

    @PostMapping(ApiMappings.EXERCISE_LOG_MAPPING)
    public ResponseEntity<ExerciseLogResponse> createAndGetExerciseLog(
            @RequestParam(name = "title", defaultValue = "exercise") String exerciseTitle,
            @PathVariable Long trainingLogId) {

        ExerciseLogResponse logResponse = trainingFacade.createExerciseLog(exerciseTitle, trainingLogId);
        return new ResponseEntity<>(logResponse, HttpStatus.CREATED);
    }

    @PostMapping(ApiMappings.SERIES_LOG_MAPPING)
    public ResponseEntity<SeriesLogResponse> createAndGetExerciseLog(
            @PathVariable Long exerciseLogId,
            @RequestParam(name = "reps") Integer reps,
            @RequestParam(name = "weight") Float weight) {

        SeriesLogResponse logResponse = trainingFacade.createSeriesLog(exerciseLogId, reps, weight);
        return new ResponseEntity<>(logResponse, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TrainingLogResponse>> getTrainingLogs() {
        List<TrainingLogResponse> logResponses = trainingFacade.getTrainingLogsForCurrentUser();
        return new ResponseEntity<>(logResponses, HttpStatus.OK);
    }

    @GetMapping(ApiMappings.TRAINING_LOG_MAPPING + "/{trainingId}")
    public ResponseEntity<TrainingLogResponse> getTrainingLog(@PathVariable Long trainingId) {
        TrainingLogResponse logResponse = trainingFacade.getTrainingLogResponse(trainingId);
        return new ResponseEntity<>(logResponse, HttpStatus.OK);
    }

    @GetMapping(ApiMappings.EXERCISE_LOG_MAPPING + "/{exerciseId}")
    public ResponseEntity<ExerciseLogResponse> getExerciseLog(@PathVariable Long exerciseId) {
        ExerciseLogResponse logResponse = trainingFacade.getExerciseLogResponse(exerciseId);
        return new ResponseEntity<>(logResponse, HttpStatus.OK);
    }

    @GetMapping(ApiMappings.SERIES_LOG_MAPPING + "/{seriesId}")
    public ResponseEntity<SeriesLogResponse> getSeriesLog(@PathVariable Long seriesId) {
        SeriesLogResponse logResponse = trainingFacade.getSeriesLogResponse(seriesId);
        return new ResponseEntity<>(logResponse, HttpStatus.OK);
    }

    @DeleteMapping(ApiMappings.TRAINING_LOG_MAPPING + "/{trainingLogId}")
    public void deleteTrainingLog(@PathVariable Long trainingLogId) {
        trainingFacade.deleteTrainingLog(trainingLogId);
    }

    @DeleteMapping(ApiMappings.EXERCISE_LOG_MAPPING + "/{exerciseLogId}")
    public void deleteExerciseLog(@PathVariable Long exerciseLogId) {
        trainingFacade.deleteExerciseLog(exerciseLogId);
    }

    @DeleteMapping(ApiMappings.SERIES_LOG_MAPPING + "/{seriesLogId}")
    public void deleteSeriesLog(@PathVariable Long seriesLogId) {
        trainingFacade.deleteSeriesLog(seriesLogId);
    }

}
