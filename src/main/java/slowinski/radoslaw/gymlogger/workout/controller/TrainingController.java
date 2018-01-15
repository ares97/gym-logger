package slowinski.radoslaw.gymlogger.workout.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import slowinski.radoslaw.gymlogger.exception.WorkoutNotFoundException;
import slowinski.radoslaw.gymlogger.utilities.ApiMappings;
import slowinski.radoslaw.gymlogger.workout.entity.ExerciseLog;
import slowinski.radoslaw.gymlogger.workout.entity.SeriesLog;
import slowinski.radoslaw.gymlogger.workout.entity.TrainingLog;
import slowinski.radoslaw.gymlogger.workout.model.response.ExerciseLogResponse;
import slowinski.radoslaw.gymlogger.workout.model.response.SeriesLogResponse;
import slowinski.radoslaw.gymlogger.workout.model.response.TrainingLogResponse;
import slowinski.radoslaw.gymlogger.workout.service.TrainingFacade;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(ApiMappings.LOGS_V1)
class TrainingController {

    @Autowired
    TrainingFacade trainingFacade;

    @GetMapping
    public ResponseEntity<List<TrainingLogResponse>> getTrainingLogs() {
        List<TrainingLogResponse> logResponses = trainingFacade.getTrainingLogsForCurrentUser();
        return new ResponseEntity<>(logResponses, HttpStatus.OK);
    }

    @PostMapping(ApiMappings.TRAINING_LOG_MAPPING)
    public ResponseEntity<TrainingLogResponse> createAndGetTrainingLog(
            @RequestParam(name = "date")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate localDate) {

        TrainingLogResponse logResponse = trainingFacade.createTrainingLog(localDate);
        return new ResponseEntity<>(logResponse, HttpStatus.CREATED);
    }

    @PostMapping(ApiMappings.EXERCISE_LOG_MAPPING)
    public ResponseEntity<ExerciseLogResponse> createExerciseLog(
            @RequestParam(name = "exercise", defaultValue = "exercise") String exerciseTitle,
            @PathVariable TrainingLog trainingLog) {

        ExerciseLogResponse logResponse =
                Optional.ofNullable(trainingLog).
                        map(t -> trainingFacade.createExerciseLog(exerciseTitle, t)).
                        orElseThrow(() -> new WorkoutNotFoundException("could find training log with such id"));

        return new ResponseEntity<>(logResponse, HttpStatus.CREATED);
    }

    @PostMapping(ApiMappings.SERIES_LOG_MAPPING)
    public ResponseEntity<SeriesLogResponse> addSeriesLog(
            @PathVariable ExerciseLog exerciseLog,
            @RequestParam(name = "reps") Integer reps,
            @RequestParam(name = "weight") Float weight) {

        SeriesLogResponse logResponse =
                Optional.ofNullable(exerciseLog).
                        map(e -> trainingFacade.addSeriesLog(e, reps, weight)).
                        orElseThrow(() -> new WorkoutNotFoundException("could find exercise log with such id"));

        return new ResponseEntity<>(logResponse, HttpStatus.CREATED);
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

    @DeleteMapping(ApiMappings.TRAINING_LOG_MAPPING + "/{trainingLog}")
    public void deleteTrainingLog(@PathVariable TrainingLog trainingLog) {
        trainingFacade.deleteTrainingLog(
                Optional.ofNullable(trainingLog).orElseThrow(
                        () -> new WorkoutNotFoundException("could find training log with such id")));
    }

    @DeleteMapping(ApiMappings.EXERCISE_LOG_MAPPING + "/{exerciseLog}")
    public void deleteExerciseLog(@PathVariable ExerciseLog exerciseLog) {
        trainingFacade.deleteExerciseLog(
                Optional.ofNullable(exerciseLog).orElseThrow(
                        () -> new WorkoutNotFoundException("could find exercise log with such id")));
    }

    @DeleteMapping(ApiMappings.SERIES_LOG_MAPPING + "/{seriesLog}")
    public void deleteExerciseLog(@PathVariable SeriesLog seriesLog) {
        trainingFacade.deleteSeriesLog(
                Optional.ofNullable(seriesLog).orElseThrow(
                        () -> new WorkoutNotFoundException("could find series log with such id")));
    }

}
