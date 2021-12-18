package ua.training.petproject.upload;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@EnableBinding(EventCommunications.class)
@RequiredArgsConstructor
public class StorageEventListener {

    private final ObjectMapper objectMapper;

    @SneakyThrows
    @StreamListener(EventCommunications.STORAGE_EVENT)
    public void handleMessage(String storageEventBody) {
        JsonNode event = objectMapper.readTree(storageEventBody);
        String filename = event.get("name").asText();
        System.out.println(filename);
    }
}
