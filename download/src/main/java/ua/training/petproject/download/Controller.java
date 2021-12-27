package ua.training.petproject.download;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class Controller {

    private final BucketDownloadService service;

    @GetMapping
    public Resource downloadFile(@RequestParam String filename) {
        return service.downloadFile(filename);
    }
}
