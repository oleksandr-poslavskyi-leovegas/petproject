package ua.training.petproject.search;

import org.elasticsearch.common.UUIDs;
import org.springframework.data.elasticsearch.core.event.BeforeConvertCallback;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.stereotype.Component;

@Component
public class MetadataBeforeConvertCallback implements BeforeConvertCallback<Metadata> {

    @Override
    public Metadata onBeforeConvert(Metadata metadata, IndexCoordinates indexCoordinates) {
        if (metadata.getId() == null) {
            metadata.setId(UUIDs.randomBase64UUID());
        }
        return metadata;
    }
}