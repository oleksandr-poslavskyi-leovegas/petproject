package ua.training.petproject.upload;

import java.util.Set;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class UploadRequest {
    private String description;
    private Set<String> tags;
    private MultipartFile file;
}
