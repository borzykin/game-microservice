package dev.bozykin.usermicroservice.service;

import dev.bozykin.usermicroservice.entity.GameEntity;
import dev.bozykin.usermicroservice.repository.GameRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GameService {
    private final GameRepository gameRepository;

    public List<GameEntity> getAllGames() {
        return (List<GameEntity>) gameRepository.findAll();
    }

}
