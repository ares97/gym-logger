package slowinski.radoslaw.gymlogger.workout.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import slowinski.radoslaw.gymlogger.utilities.ApiMappings;
import slowinski.radoslaw.gymlogger.workout.entity.ExerciseLog;
import slowinski.radoslaw.gymlogger.workout.entity.TrainingLog;
import slowinski.radoslaw.gymlogger.workout.exception.WorkoutNotFoundException;
import slowinski.radoslaw.gymlogger.workout.model.response.ExerciseLogResponse;
import slowinski.radoslaw.gymlogger.workout.model.response.SeriesLogResponse;
import slowinski.radoslaw.gymlogger.workout.model.response.TrainingLogResponse;
import slowinski.radoslaw.gymlogger.workout.service.TrainingFacade;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(ApiMappings.LOGS_V1)
public class TrainingController {

    @Autowired
    TrainingFacade trainingFacade;

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

        if (!Optional.ofNullable(trainingLog).isPresent())
            throw new WorkoutNotFoundException("no such training log available");

        ExerciseLogResponse logResponse = trainingFacade.createExerciseLog(exerciseTitle, trainingLog);
        return new ResponseEntity<>(logResponse, HttpStatus.CREATED);

    }

    @PostMapping(ApiMappings.SERIES_LOG_MAPPING)
    public ResponseEntity<SeriesLogResponse> addSeriesLog(
            @PathVariable ExerciseLog exerciseLog,
            @RequestParam(name = "reps") Integer reps,
            @RequestParam(name = "weight") Float weight) {

        if (!Optional.ofNullable(exerciseLog).isPresent())
            throw new WorkoutNotFoundException("no such exercise log available");

        SeriesLogResponse logResponse = trainingFacade.addSeriesLog(exerciseLog, reps, weight);
        return new ResponseEntity<>(logResponse, HttpStatus.CREATED);
    }

    @GetMapping
    public List<TrainingLog> getTrainingLogs() {
        return trainingFacade.getTrainingLogs();
    }

}
