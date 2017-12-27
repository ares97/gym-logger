package slowinski.radoslaw.gymlogger.exercise.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import slowinski.radoslaw.gymlogger.exercise.entity.Exercise;
import slowinski.radoslaw.gymlogger.exercise.exception.ExerciseConflictException;
import slowinski.radoslaw.gymlogger.exercise.repository.ExerciseRepository;
import slowinski.radoslaw.gymlogger.exercise.service.ExerciseService;

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
            throw new ExerciseConflictException("exercise with title '" + exercise.getTitle() + "' already exists");
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
        exercise.setDescription("custom exercise");
        exerciseRepository.saveAndFlush(exercise);
        return exercise;
    }

}
