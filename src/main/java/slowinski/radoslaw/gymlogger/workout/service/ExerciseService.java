package slowinski.radoslaw.gymlogger.workout.service;

import slowinski.radoslaw.gymlogger.workout.entity.Exercise;

import java.util.List;

public interface ExerciseService {
    List<Exercise> getExercises();

    void addExercise(Exercise exercise);

    Exercise findExerciseByTitle(String title);

    Exercise createCustomExercise(String exTitle);
}
