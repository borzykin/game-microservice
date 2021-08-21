package dev.bozykin.usermicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class GameMicroserviceApplication {
	final String host = System.getProperty("user.service.host", "localhost");
	final String port = System.getProperty("user.service.port", "8090");

	public static void main(String[] args) {
		SpringApplication.run(GameMicroserviceApplication.class, args);
	}

	@Bean
	public WebClient localApiClient() {
		return WebClient.create(String.format("http://%s:%s/api/v1/users", host, port));
	}

}
