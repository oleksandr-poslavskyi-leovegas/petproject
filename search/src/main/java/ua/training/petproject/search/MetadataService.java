package ua.training.petproject.search;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MetadataService {

    private final MetadataRepository repository;

    public Iterable<Metadata> findAll() {
        return repository.findAll();
    }

    public void save(Metadata metadata) {
        repository.save(metadata);
    }
}
