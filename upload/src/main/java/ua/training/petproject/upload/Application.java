package ua.training.petproject.upload;

import java.util.function.Consumer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import ua.training.petproject.upload.service.MetadataService;

@SpringBootApplication
public class Application {

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	public Consumer<String> storageEventCallback(MetadataService metadataService) {
		return metadataService::storeMetadataByFilename;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
