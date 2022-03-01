package ua.training.petproject.search;

import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class Controller {

    private final MetadataService service;
    private final Environment environment;

    @GetMapping("/all")
    public Iterable<Metadata> getAll() {
        return service.findAll();
    }

    @GetMapping("/byTags")
    public Iterable<Metadata> getByTags(@RequestParam Set<String> tags) {
        return service.findByTags(tags);
    }

    @GetMapping("/byDescription")
    public Iterable<Metadata> getByDescription(@RequestParam String desc) {
        return service.findByDescription(desc);
    }

    @PostMapping("/save")
    public void save(@RequestBody Metadata metadata) {
        mimicErrorState();
        service.save(metadata);
    }

    private void mimicErrorState() {
        if (environment.acceptsProfiles(Profiles.of("broken"))) {
            throw new RuntimeException("This is fake error");
        }
    }
}
