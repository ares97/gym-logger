package slowinski.radoslaw.gymlogger.workout.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import slowinski.radoslaw.gymlogger.utilities.ApiMappings;
import slowinski.radoslaw.gymlogger.workout.entity.ExerciseLog;
import slowinski.radoslaw.gymlogger.workout.entity.SeriesLog;
import slowinski.radoslaw.gymlogger.workout.exception.ExerciseNotFoundException;
import slowinski.radoslaw.gymlogger.workout.service.SeriesLogService;

@RestController
@RequestMapping(ApiMappings.SERIES_LOG_V1)
public class SeriesLogController {

    @Autowired
    SeriesLogService seriesLogService;

    @PostMapping("/{exerciseLog}")
    @ResponseStatus(HttpStatus.CREATED)
    public void addSeries(@RequestBody SeriesLog seriesLog, @PathVariable ExerciseLog exerciseLog) {
        if (exerciseLog == null)
            throw new ExerciseNotFoundException("cannot add series into non-existing workout log");
        seriesLogService.addSeries(seriesLog, exerciseLog);
    }
}
