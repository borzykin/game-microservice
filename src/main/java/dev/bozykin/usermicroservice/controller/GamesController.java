package dev.bozykin.usermicroservice.controller;

import dev.bozykin.usermicroservice.service.GameService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
