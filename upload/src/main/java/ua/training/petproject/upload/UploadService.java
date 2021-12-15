package ua.training.petproject.upload;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;
import javax.annotation.PostConstruct;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UploadService {

    @Value("${local.uploadDir}")
    private String uploadDir;

    @PostConstruct
    public void validateDirectory() {
        File dir = Paths.get(uploadDir).toFile();
        if (!dir.exists()) {
            throw new RuntimeException("Upload dir not found");
        }
        if (!dir.isDirectory()) {
            throw new RuntimeException("Upload dir is not a directory");
        }
    }

    @SneakyThrows
    public String uploadFile(UploadRequest request) {
        Path destination = Paths.get(uploadDir, UUID.randomUUID().toString());
        request.getFile().transferTo(destination);
        return destination.toAbsolutePath().toString();
    }
}
