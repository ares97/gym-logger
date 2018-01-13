package slowinski.radoslaw.gymlogger.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class ForbiddenDataAccessException extends RuntimeException {

    public ForbiddenDataAccessException() {
        super("You are not allowed to get access to this resource");
    }
}
