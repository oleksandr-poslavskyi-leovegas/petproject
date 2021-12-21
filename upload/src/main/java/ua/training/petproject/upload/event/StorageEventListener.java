package ua.training.petproject.upload.event;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.function.Consumer;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@EnableBinding(EventCommunications.class)
@RequiredArgsConstructor
public class StorageEventListener {

    private final ObjectMapper objectMapper;
    private final Consumer<String> storageEventCallback;

    @SneakyThrows
    @StreamListener(EventCommunications.STORAGE_EVENT)
    public void handleMessage(String storageEventBody) {
        JsonNode event = objectMapper.readTree(storageEventBody);
        String filename = event.get("name").asText();
        storageEventCallback.accept(filename);
    }
}
