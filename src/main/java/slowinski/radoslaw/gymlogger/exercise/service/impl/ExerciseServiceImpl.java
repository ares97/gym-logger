package slowinski.radoslaw.gymlogger.exercise.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import slowinski.radoslaw.gymlogger.exercise.entity.Exercise;
import slowinski.radoslaw.gymlogger.exercise.repository.ExerciseRepository;
import slowinski.radoslaw.gymlogger.exercise.service.ExerciseService;

import java.util.List;

@Service
public class ExerciseServiceImpl implements ExerciseService {

    @Autowired
    ExerciseRepository exerciseRepository;

    public List<Exercise> getExercises() {
        return exerciseRepository.findAll();
    }

    public void addExercise(Exercise exercise) {
        exerciseRepository.save(exercise);
    }

}
