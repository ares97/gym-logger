package slowinski.radoslaw.gymlogger.workout.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import slowinski.radoslaw.gymlogger.utilities.ApiMappings;
import slowinski.radoslaw.gymlogger.workout.entity.Exercise;
import slowinski.radoslaw.gymlogger.workout.service.ExerciseService;

import java.util.List;

@RestController
@RequestMapping(ApiMappings.EXERCISE_V1)
public class ExerciseController {
    @Autowired
    ExerciseService exerciseService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Exercise> getExercises() {
        return exerciseService.getExercises();
    }

    @GetMapping("/{title}")
    @ResponseStatus(HttpStatus.OK)
    public Exercise getExercise(@PathVariable String title) {
        return exerciseService.findExerciseByTitle(title);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addExercise(@RequestBody Exercise exercise) {
        exerciseService.addExercise(exercise);
    }
}
