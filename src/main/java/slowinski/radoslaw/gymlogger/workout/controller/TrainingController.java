package slowinski.radoslaw.gymlogger.workout.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import slowinski.radoslaw.gymlogger.utilities.ApiMappings;
import slowinski.radoslaw.gymlogger.workout.entity.ExerciseLog;
import slowinski.radoslaw.gymlogger.workout.entity.TrainingLog;
import slowinski.radoslaw.gymlogger.workout.exception.WorkoutNotFoundException;
import slowinski.radoslaw.gymlogger.workout.service.TrainingFacade;

import java.time.LocalDate;
import java.util.Optional;

@RestController
@RequestMapping(ApiMappings.TRAINING_V1)
public class TrainingController {

    @Autowired
    TrainingFacade trainingFacade;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Long createAndGetTrainingLog(
            @RequestParam(name = "date")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate localDate) {

        return trainingFacade.createTrainingLog(localDate);
    }

    @PostMapping("/{trainingLog}")
    public void createExerciseLog(
            @RequestParam(name = "exercise", defaultValue = "exercise") String exerciseTitle,
            @PathVariable TrainingLog trainingLog) {

        if (!Optional.ofNullable(trainingLog).isPresent())
            throw new WorkoutNotFoundException("no such training log available");
        trainingFacade.createExerciseLog(exerciseTitle, trainingLog);
    }

    @PostMapping("/{trainingLog}/{exerciseLog}")
    public void addSeriesLog(
            @PathVariable ExerciseLog exerciseLog,
            @RequestParam(name = "reps") Integer reps,
            @RequestParam(name = "weight") Float weight) {

        if (!Optional.ofNullable(exerciseLog).isPresent())
            throw new WorkoutNotFoundException("no such exercise log available");
        trainingFacade.addSeriesLog(exerciseLog, reps, weight);
    }

}
