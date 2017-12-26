package slowinski.radoslaw.gymlogger.exercise.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class SeriesLog {

    @GeneratedValue
    @Id
    private Long id;

    private float weight;

    private int reps;

    public SeriesLog(float weight, int reps) {
        this.weight = weight;
        this.reps = reps;
    }

    public SeriesLog() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }
}
