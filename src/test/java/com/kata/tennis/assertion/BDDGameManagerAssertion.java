package com.kata.tennis.assertion;

import org.assertj.core.api.BDDAssertions;
import com.kata.tennis.GameManager;
import com.kata.tennis.modele.GameScore;
import javafx.util.Pair;

/**
 * @author Benjamin Socquet-Juglard (dvd3384)
 */
public class BDDGameManagerAssertion {

    private Pair<Integer, Integer> score;
    private final GameManager gameManager;

    public BDDGameManagerAssertion() {
        gameManager = new GameManager();
    }

    public BDDGameManagerAssertion givenBaseScoreOf(final Integer firstPlayerScore, final Integer secondPlayerScore) {
        gameManager.setScore(new GameScore(firstPlayerScore, secondPlayerScore));
        return this;
    }

    public BDDGameManagerAssertion givenGameHasBeenWonByPlayer(final int playerNumber) {
        gameManager.setWinner(playerNumber);
        return this;
    }

    public BDDGameManagerAssertion whenFirstPlayerWinASet() {
        gameManager.playerWinAPoint(1);
        return this;
    }

    public BDDGameManagerAssertion whenSecondPlayerWinASet() {
        gameManager.playerWinAPoint(2);
        return this;
    }

    public BDDGameManagerAssertion thenScoreIs(final Integer firstPlayerScore, final Integer secondPlayerScore) {
        BDDAssertions.then(gameManager.getScore()).isEqualTo(new GameScore(firstPlayerScore, secondPlayerScore));
        return this;
    }

    public BDDGameManagerAssertion thenFirstPlayerHasWon() {
        BDDAssertions.then(gameManager.getWinner()).isEqualTo(1);
        return this;
    }

    public BDDGameManagerAssertion thenSecondPlayerHasWon() {
        BDDAssertions.then(gameManager.getWinner()).isEqualTo(2);
        return this;
    }

    public BDDGameManagerAssertion thenGameContinue() {
        BDDAssertions.then(gameManager.getWinner()).isNull();
        return this;
    }
}
