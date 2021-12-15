package ua.training.petproject.search;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class Controller {

    private final MetadataService service;

    @GetMapping
    public String message() {
        return "Hello from search module";
    }

    @GetMapping("/all")
    public Iterable<Metadata> getAll() {
        return service.findAll();
    }

    @PostMapping("/save")
    public void save(@RequestBody Metadata metadata) {
        service.save(metadata);
    }
}
