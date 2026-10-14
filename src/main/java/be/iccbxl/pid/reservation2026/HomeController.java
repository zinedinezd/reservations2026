package be.iccbxl.pid.reservation2026;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HomeController {

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

}