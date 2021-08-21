package dev.bozykin.usermicroservice;

import dev.bozykin.usermicroservice.controller.GamesController;
import dev.bozykin.usermicroservice.domain.EloCalculator;
import dev.bozykin.usermicroservice.exception.NoSuchGameException;
import dev.bozykin.usermicroservice.model.AddGameRequest;
import dev.bozykin.usermicroservice.service.GameService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.naming.directory.InvalidAttributesException;
import java.util.UUID;

@SpringBootTest
class GameMicroserviceApplicationTests {
    // Expected score source: https://ratings.fide.com/calculator_rtd.phtml

    @Autowired
    private GamesController gamesController;
    @Autowired
    private GameService gameService;


    @Test
    void calcTest1() {
        // player A (score 2000) wins over player B (score 2000).
        Assertions.assertEquals(10, new EloCalculator(2000, 2000).getWinnerScoreGained(), 0.25);
    }

    @Test
    void calcTest2() {
        // player A (score 1200) wins over player B (score 1000).
        Assertions.assertEquals(4.8, new EloCalculator(1200, 1000).getWinnerScoreGained(), 0.25);
    }

    @Test
    void calcTest3() {
        // player A (score 1200) loses to player B (score 1000).
        Assertions.assertEquals(15.2, new EloCalculator(1000, 1200).getLooserScoreLost(), 0.25);
    }

    @Test
    void calcTest4() {
        // player A (score 1000) loses to player B (score 1400).
        Assertions.assertEquals(1.6, new EloCalculator(1400, 1000).getLooserScoreLost(), 0.25);
    }

    @Test
    void getGamesTest() {
        Assertions.assertTrue(gamesController.getAllGames().getStatusCode().is2xxSuccessful());
    }

    @Test
    void getGameInvalidIdTest() {
        Assertions.assertThrows(NoSuchGameException.class, () -> {
            gameService.getGameById(UUID.fromString("00000000-0000-0000-0000-000000000000"));
        });
    }

    @Test
    void addGameInvalidIdTest() {
        Assertions.assertThrows(InvalidAttributesException.class, () -> {
            gameService.addGameForUsers(new AddGameRequest(null, null));
        });
    }
}
