package ua.training.petproject.search;

import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MetadataService {

    private final MetadataRepository repository;

    public Iterable<Metadata> findAll() {
        return repository.findAll();
    }

    public Iterable<Metadata> findByTags(Set<String> tags) {
        return repository.findByTagsIn(tags);
    }

    public Iterable<Metadata> findByDescription(String desc) {
        return repository.findByDescriptionContaining(desc);
    }

    public void save(Metadata metadata) {
        repository.save(metadata);
    }
}
