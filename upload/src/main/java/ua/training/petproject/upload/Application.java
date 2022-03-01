package ua.training.petproject.upload;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.circuitbreaker.internal.CircuitBreakerStateMachine;
import java.util.function.Consumer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import ua.training.petproject.upload.service.MetadataService;

@SpringBootApplication
public class Application {

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	public Consumer<String> storageEventCallback(MetadataService metadataService) {
		return metadataService::storeMetadataByFilename;
	}

	@Bean
	public CircuitBreaker circuitBreaker() {
		return new CircuitBreakerStateMachine("defaultCircuitBreaker",
				CircuitBreakerConfig.custom().minimumNumberOfCalls(2).build());
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
