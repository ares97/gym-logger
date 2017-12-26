package slowinski.radoslaw.gymlogger.exercise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import slowinski.radoslaw.gymlogger.exercise.entity.Exercise;
import slowinski.radoslaw.gymlogger.exercise.service.ExerciseService;

import java.util.List;

@RestController
@RequestMapping("/exercise")
public class ExerciseController {
    @Autowired
    ExerciseService exerciseService;

    @GetMapping
    @ResponseStatus(HttpStatus.FOUND)
    public List<Exercise> getExercises() {
        return exerciseService.getExercises();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addExercise(@RequestBody Exercise exercise) {
        exerciseService.addExercise(exercise);
    }
}
