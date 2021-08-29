package dev.bozykin.usermicroservice.client;

import dev.bozykin.usermicroservice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.Duration;
import java.util.UUID;

@Service
public class UserClient {
    private static final Duration REQUEST_TIMEOUT = Duration.ofSeconds(3);
    private final WebClient localApiClient;

    @Autowired
    public UserClient(final WebClient localApiClient) {
        this.localApiClient = localApiClient;
    }

    public User getUser(final UUID id) {
        return localApiClient
                .get()
                .uri("/" + id)
                .retrieve()
                .bodyToMono(User.class)
                .block(REQUEST_TIMEOUT);
    }
}
