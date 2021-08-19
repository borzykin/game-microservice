package dev.bozykin.usermicroservice.controller;

import dev.bozykin.usermicroservice.model.AddGameRequest;
import dev.bozykin.usermicroservice.service.GameService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/games")
public class GamesController {
    private final GameService gameService;

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
            return ResponseEntity.ok().body(gameService.addGameForUsers(game));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
