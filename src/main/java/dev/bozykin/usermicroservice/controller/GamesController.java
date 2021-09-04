package dev.bozykin.usermicroservice.controller;

import dev.bozykin.usermicroservice.entity.GameEntity;
import dev.bozykin.usermicroservice.model.AddGameRequest;
import dev.bozykin.usermicroservice.service.GameService;
import dev.bozykin.usermicroservice.service.SnsSender;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/games")
public class GamesController {
    private final GameService gameService;
    private final SnsSender snsSender;

    @GetMapping
    public ResponseEntity getAllGames() {
        try {
            return ResponseEntity.ok().body(gameService.getAllGames());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getGameById(@PathVariable UUID id) {
        try {
            return ResponseEntity.ok().body(gameService.getGameById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/add")
    public ResponseEntity addGameForUsers(@RequestBody AddGameRequest game) {
        try {
            ResponseEntity<GameEntity> response = ResponseEntity.ok().body(gameService.addGameForUsers(game));
            snsSender.send(response.getBody(), "add-game");
            return response;
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
