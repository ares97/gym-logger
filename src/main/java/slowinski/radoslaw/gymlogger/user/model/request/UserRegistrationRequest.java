package slowinski.radoslaw.gymlogger.user.model.request;

import javax.validation.constraints.NotNull;

public class UserRegistrationRequest {

    @NotNull(message = "username field can't be empty")
    private String username;

    @NotNull(message = "password field can't be empty")
    private String password;


    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
