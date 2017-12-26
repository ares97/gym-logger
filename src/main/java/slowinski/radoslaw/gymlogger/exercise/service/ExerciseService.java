package slowinski.radoslaw.gymlogger.exercise.service;

import slowinski.radoslaw.gymlogger.exercise.entity.Exercise;

import java.util.List;

public interface ExerciseService {
    List<Exercise> getExercises();

    void addExercise(Exercise exercise);

    Exercise findExercise(Long id);
}
