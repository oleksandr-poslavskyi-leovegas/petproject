package ua.training.petproject.upload;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class Controller {

    private final UploadService uploadService;

    @PostMapping
    public String upload(@ModelAttribute UploadRequest request) {
        return uploadService.uploadFile(request);
    }
}
