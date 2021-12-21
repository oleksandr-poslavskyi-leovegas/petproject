package ua.training.petproject.upload.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.training.petproject.upload.service.UploadService;

@RestController
@RequiredArgsConstructor
public class Controller {

    private final UploadService uploadService;

    @PostMapping
    public String upload(@ModelAttribute UploadRequest request) {
        return uploadService.uploadFile(request);
    }
}
