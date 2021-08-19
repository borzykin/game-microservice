package dev.bozykin.usermicroservice.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class AddGameRequest {
    private final UUID winnerId;
    private final UUID looserId;
}
