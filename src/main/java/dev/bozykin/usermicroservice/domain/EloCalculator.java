package dev.bozykin.usermicroservice.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
public class EloCalculator {
    private final double winnerScore;
    private final double looserScore;
    private final double winnerScoreGained;
    private final double looserScoreLost;

    public EloCalculator(double winnerScore, double looserScore) {
        this.winnerScore = winnerScore;
        this.looserScore = looserScore;
        // todo the formula implementation is kinda garbage, is it better is in another timeline
        this.winnerScoreGained = (winnerScore + 20 * (1 - chance(winnerScore, looserScore))) - winnerScore;
        this.looserScoreLost = looserScore - (looserScore + 20 * (0 - chance(looserScore, winnerScore)));
    }

    private double chance(double a, double b) {
        return 1.0 / (1.0 + Math.pow(10, ((b - a) / 400)));
    }
}
