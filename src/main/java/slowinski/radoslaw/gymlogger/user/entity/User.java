package slowinski.radoslaw.gymlogger.user.entity;

import slowinski.radoslaw.gymlogger.workout.entity.TrainingLog;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "userProfile")
public class User {

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    private Long id;

    private String username;

    private String password;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Role> role;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "user")
    private List<TrainingLog> trainingLogs;

    public User() {
    }

    public User(String username, String password, List<Role> role) {
        this.username = username;
        this.password = password;
        this.role = role;
        trainingLogs = Collections.emptyList();
    }

    public List<TrainingLog> getTrainingLogs() {
        return trainingLogs;
    }

    public void setTrainingLogs(List<TrainingLog> trainingLogs) {
        this.trainingLogs = trainingLogs;
    }

    public List<Role> getRole() {
        return role;
    }

    public void setRole(List<Role> role) {
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}




