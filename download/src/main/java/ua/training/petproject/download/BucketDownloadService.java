package ua.training.petproject.download;

import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.Storage;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BucketDownloadService {

    private final Storage storage;
    @Value("${cloud.uploadBucket}")
    private String bucketName;

    @SneakyThrows
    public Resource downloadFile(String filename) {
        Bucket bucket = storage.get(bucketName);
        return new ByteArrayResource(bucket.get(filename).getContent());
    }
}
