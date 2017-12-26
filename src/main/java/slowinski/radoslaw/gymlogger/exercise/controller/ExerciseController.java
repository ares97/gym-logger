package slowinski.radoslaw.gymlogger.exercise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import slowinski.radoslaw.gymlogger.exercise.entity.Exercise;
import slowinski.radoslaw.gymlogger.exercise.service.ExerciseService;
import slowinski.radoslaw.gymlogger.utilities.ResourceMappings;

import java.util.List;

@RestController
@RequestMapping(ResourceMappings.EXERCISE_V1)
public class ExerciseController {
    @Autowired
    ExerciseService exerciseService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Exercise> getExercises() {
        return exerciseService.getExercises();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> getExcersise(@PathVariable Long id) {
        Exercise exercise = exerciseService.findExercise(id);
        if (exercise == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(exercise, HttpStatus.OK);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addExercise(@RequestBody Exercise exercise) {
        exerciseService.addExercise(exercise);
    }
}
