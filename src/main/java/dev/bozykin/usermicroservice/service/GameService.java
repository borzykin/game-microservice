package dev.bozykin.usermicroservice.service;

import dev.bozykin.usermicroservice.entity.GameEntity;
import dev.bozykin.usermicroservice.exception.NoSuchGameException;
import dev.bozykin.usermicroservice.model.AddGameRequest;
import dev.bozykin.usermicroservice.repository.GameRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.naming.directory.InvalidAttributesException;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class GameService {
    private final GameRepository gameRepository;

    public List<GameEntity> getAllGames() {
        return (List<GameEntity>) gameRepository.findAll();
    }

    public GameEntity getGameById(final UUID id) throws NoSuchGameException {
        if (gameRepository.findById(id).isEmpty()) {
            throw new NoSuchGameException("No game with id: " + id);
        } else {
            return gameRepository.findById(id).get();
        }
    }

    public GameEntity addGameForUsers(final AddGameRequest game) throws InvalidAttributesException {
        if (game.getWinnerId() == null || game.getLooserId() == null || game.getWinnerId().equals(game.getLooserId())) {
            throw new InvalidAttributesException("Invalid input");
        } else {
            var gameEntity = new GameEntity()
                    .setWinner(game.getWinnerId())
                    .setLooser(game.getLooserId())
                    .setScoreGained(10.1)
                    .setScoreLost(9.9)
                    .setCreatedOn(OffsetDateTime.now(ZoneOffset.UTC));
            return gameRepository.save(gameEntity);
        }
    }
}
