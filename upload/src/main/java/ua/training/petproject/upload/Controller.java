package ua.training.petproject.upload;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping
    public String message() {
        return "Hello from upload module";
    }
}
