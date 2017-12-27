package slowinski.radoslaw.gymlogger.exercise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import slowinski.radoslaw.gymlogger.exercise.entity.ExerciseLog;
import slowinski.radoslaw.gymlogger.exercise.entity.SeriesLog;
import slowinski.radoslaw.gymlogger.exercise.exception.ExerciseNotFoundException;
import slowinski.radoslaw.gymlogger.exercise.service.SeriesLogService;
import slowinski.radoslaw.gymlogger.utilities.ResourceMappings;

@RestController
@RequestMapping(ResourceMappings.SERIES_LOG_V1)
public class SeriesLogController {

    @Autowired
    SeriesLogService seriesLogService;

    @PostMapping("/{exerciseLog}")
    @ResponseStatus(HttpStatus.CREATED)
    public void addSeries(@RequestBody SeriesLog seriesLog, @PathVariable ExerciseLog exerciseLog) {
        if (exerciseLog == null)
            throw new ExerciseNotFoundException("cannot add series into non-existing exercise log");
        seriesLogService.addSeries(seriesLog, exerciseLog);
    }
}
