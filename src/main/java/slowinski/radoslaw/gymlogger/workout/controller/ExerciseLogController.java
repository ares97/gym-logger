package slowinski.radoslaw.gymlogger.workout.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import slowinski.radoslaw.gymlogger.utilities.ApiMappings;
import slowinski.radoslaw.gymlogger.workout.entity.ExerciseLog;
import slowinski.radoslaw.gymlogger.workout.service.ExerciseLogService;

import java.util.List;

@RestController
@RequestMapping(ApiMappings.EXERCISE_LOG_V1)
public class ExerciseLogController {

    @Autowired
    ExerciseLogService exerciseLogService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ExerciseLog> getExerciseLogs() {
        return exerciseLogService.getExerciseLogs();
    }

    @PostMapping("/{exerciseTitle}")
    @ResponseStatus(HttpStatus.CREATED)
    public void addExerciseLog(@PathVariable String exerciseTitle) {
        exerciseLogService.createExerciseLog(exerciseTitle);
    }


}
