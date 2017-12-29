package slowinski.radoslaw.gymlogger;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class BlablaController {

    @GetMapping
    public String getHello() {
        return "Hello!";
    }
}
