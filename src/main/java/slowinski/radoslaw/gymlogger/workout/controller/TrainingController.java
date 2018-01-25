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
@RequestMapping(ApiMappings.API_LOGS)
class TrainingController {

    @Autowired
    TrainingFacade trainingFacade;

    @PostMapping(ApiMappings.API_POST_TRAINING)
    public ResponseEntity<TrainingLogResponse> createAndGetTrainingLog(
            @RequestParam(name = "date")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @Valid LocalDate localDate) {

        TrainingLogResponse logResponse = trainingFacade.createTrainingLog(localDate);
        return new ResponseEntity<>(logResponse, HttpStatus.CREATED);
    }

    @PostMapping(ApiMappings.API_POST_EXERCISE)
    public ResponseEntity<ExerciseLogResponse> createAndGetExerciseLog(
            @RequestParam(name = "title", defaultValue = "exercise") String exerciseTitle,
            @PathVariable Long trainingLogId) {

        ExerciseLogResponse logResponse = trainingFacade.createExerciseLog(exerciseTitle, trainingLogId);
        return new ResponseEntity<>(logResponse, HttpStatus.CREATED);
    }

    @PostMapping(ApiMappings.API_POST_SERIES)
    public ResponseEntity<SeriesLogResponse> createAndGetSeriesLog(
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

    @GetMapping(ApiMappings.API_GET_TRAINING)
    public ResponseEntity<TrainingLogResponse> getTrainingLog(@PathVariable Long trainingLogId) {
        TrainingLogResponse logResponse = trainingFacade.getTrainingLogResponse(trainingLogId);
        return new ResponseEntity<>(logResponse, HttpStatus.OK);
    }

    @GetMapping(ApiMappings.API_GET_EXERCISE)
    public ResponseEntity<ExerciseLogResponse> getExerciseLog(@PathVariable Long exerciseLogId) {
        ExerciseLogResponse logResponse = trainingFacade.getExerciseLogResponse(exerciseLogId);
        return new ResponseEntity<>(logResponse, HttpStatus.OK);
    }

    @GetMapping(ApiMappings.API_GET_SERIES)
    public ResponseEntity<SeriesLogResponse> getSeriesLog(@PathVariable Long seriesLogId) {
        SeriesLogResponse logResponse = trainingFacade.getSeriesLogResponse(seriesLogId);
        return new ResponseEntity<>(logResponse, HttpStatus.OK);
    }

    @DeleteMapping(ApiMappings.API_DELETE_TRAINING)
    public void deleteTrainingLog(@PathVariable Long trainingLogId) {
        trainingFacade.deleteTrainingLog(trainingLogId);
    }

    @DeleteMapping(ApiMappings.API_DELETE_EXERCISE)
    public void deleteExerciseLog(@PathVariable Long exerciseLogId) {
        trainingFacade.deleteExerciseLog(exerciseLogId);
    }

    @DeleteMapping(ApiMappings.API_DELETE_SERIES)
    public void deleteSeriesLog(@PathVariable Long seriesLogId) {
        trainingFacade.deleteSeriesLog(seriesLogId);
    }

}
