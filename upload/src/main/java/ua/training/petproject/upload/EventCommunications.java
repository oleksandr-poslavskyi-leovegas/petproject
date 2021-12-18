package ua.training.petproject.upload;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface EventCommunications {
    String STORAGE_EVENT = "petProjectEventTopic";

    @Input(STORAGE_EVENT)
    SubscribableChannel storageEvent();
}
