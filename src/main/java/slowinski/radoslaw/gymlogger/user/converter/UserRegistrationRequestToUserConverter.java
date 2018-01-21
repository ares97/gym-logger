package slowinski.radoslaw.gymlogger.user.converter;

import org.springframework.core.convert.converter.Converter;
import slowinski.radoslaw.gymlogger.user.entity.User;
import slowinski.radoslaw.gymlogger.user.model.request.UserRegistrationRequest;

public class UserRegistrationRequestToUserConverter implements Converter<UserRegistrationRequest, User> {
    @Override
    public User convert(UserRegistrationRequest source) {
        User user = new User();

        user.setPassword(source.getPassword());
        user.setUsername(source.getUsername());

        return user;
    }

}
