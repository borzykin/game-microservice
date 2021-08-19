package dev.bozykin.usermicroservice.repository;

import dev.bozykin.usermicroservice.entity.GameEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface GameRepository extends CrudRepository<GameEntity, UUID> {
}
