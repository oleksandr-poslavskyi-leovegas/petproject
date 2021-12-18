package ua.training.petproject.upload;

import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.Storage;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
@RequiredArgsConstructor
public class BucketUploadService implements UploadService {

    private final Storage storage;

    @SneakyThrows
    @Override
    public String uploadFile(UploadRequest request) {
        Bucket bucket = storage.get("my-petproject-bucket");
        String filename = UUID.randomUUID().toString();
        bucket.create(filename, request.getFile().getBytes());
        return filename;
    }
}
