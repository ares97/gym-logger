package slowinski.radoslaw.gymlogger.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import slowinski.radoslaw.gymlogger.user.model.request.UserRegistrationRequest;
import slowinski.radoslaw.gymlogger.user.service.UserService;
import slowinski.radoslaw.gymlogger.utilities.ApiMappings;

import javax.validation.Valid;

@RestController
@RequestMapping(ApiMappings.USER)
class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/registration")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerUser(@Valid @RequestBody UserRegistrationRequest userRegistrationRequest) {
        userService.saveUserIfValid(userRegistrationRequest);
    }

    // while basic auth is being used this endpoint is redundant
    /*@GetMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        userService.logoutUser(request, response);
    }
*/
}

