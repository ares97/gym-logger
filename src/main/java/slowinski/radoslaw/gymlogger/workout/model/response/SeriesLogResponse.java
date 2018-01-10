package slowinski.radoslaw.gymlogger.workout.model.response;

import slowinski.radoslaw.gymlogger.workout.model.Links;

public class SeriesLogResponse {

    private Long id;

    private Links links;

    private float weight;

    private int reps;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
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
