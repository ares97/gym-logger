package slowinski.radoslaw.gymlogger.workout.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import slowinski.radoslaw.gymlogger.workout.entity.Exercise;
import slowinski.radoslaw.gymlogger.workout.exception.ExerciseConflictException;
import slowinski.radoslaw.gymlogger.workout.repository.ExerciseRepository;
import slowinski.radoslaw.gymlogger.workout.service.ExerciseService;

import java.util.List;

@Service
public class ExerciseServiceImpl implements ExerciseService {

    @Autowired
    ExerciseRepository exerciseRepository;

    @Override
    public List<Exercise> getExercises() {
        return exerciseRepository.findAll();
    }

    @Override
    public void addExercise(Exercise exercise) {
        if (findExerciseByTitle(exercise.getTitle()) != null)
            throw new ExerciseConflictException("workout with title '" + exercise.getTitle() + "' already exists");
        exerciseRepository.save(exercise);
    }

    @Override
    public Exercise findExerciseByTitle(String title) {
        return exerciseRepository.findByTitleIgnoreCase(title);
    }

    @Override
    public Exercise createCustomExercise(String exTitle) {
        Exercise exercise = new Exercise();
        exercise.setTitle(exTitle);
        exercise.setDescription("custom workout");
        exerciseRepository.saveAndFlush(exercise);
        return exercise;
    }

}
