package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    public WelcomeController() {
    }

    public WelcomeController(String message) {
        this.message = message;
    }

    @Value("${welcome.message}")
    private String message;

    @GetMapping("/")
    public String sayHello() {
        return message;
    }
}
