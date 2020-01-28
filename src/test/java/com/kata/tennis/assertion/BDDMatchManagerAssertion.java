package com.kata.tennis.assertion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.BDDAssertions;
import com.kata.tennis.MatchManager;
import com.kata.tennis.modele.GameScore;

/**
 * @author Benjamin Socquet-Juglard (dvd3384)
 */
public class BDDMatchManagerAssertion {

    private final MatchManager matchManager;

    public BDDMatchManagerAssertion() {
        matchManager = new MatchManager();
    }

    public BDDMatchManagerAssertion givenCurrentGameScore(int gameScoreFirstPlayer, int gameScoreSecondPlayer) {
        matchManager.setGameScore(gameScoreFirstPlayer, gameScoreSecondPlayer);
        return this;
    }

    public BDDMatchManagerAssertion givenCurrentSetScore(int setScoreFirstPlayer, int setScoreSecondPlayer) {
        matchManager.setSetScore(setScoreFirstPlayer, setScoreSecondPlayer);
        return this;
    }

    public BDDMatchManagerAssertion givenAdvantagePlayer(int playerNumber) {
        matchManager.setAdvantagePlayer(playerNumber);
        return this;
    }

    public BDDMatchManagerAssertion whenFirstPlayerScore() {
        matchManager.playerScore(1);
        return this;
    }

    public BDDMatchManagerAssertion whenFirstPlayerTwice() {
        matchManager.playerScore(1);
        matchManager.playerScore(1);
        return this;
    }

    public BDDMatchManagerAssertion whenSecondPlayerScore() {
        matchManager.playerScore(2);
        return this;
    }

    public BDDMatchManagerAssertion thenCurrentSetScore(int setScoreFirstPlayer, int setScoreSecondPlayer) {
        BDDAssertions.then(matchManager.getSetScore()).isEqualTo("(" + setScoreFirstPlayer + "-" + setScoreSecondPlayer + ")");
        return this;
    }

    public BDDMatchManagerAssertion thenCurrentGameScore(int gameScoreFirstPlayer, int gameScoreSecondPlayer) {
        BDDAssertions.then(matchManager.getGameScore()).isEqualTo(gameScoreFirstPlayer + "-" + gameScoreSecondPlayer);
        return this;
    }

    public BDDMatchManagerAssertion thenMatchScore(String matchScore) {
        BDDAssertions.then(matchManager.getMatchScore()).isEqualTo(matchScore);
        return this;
    }

    public BDDMatchManagerAssertion givenMatchScore(String matchScoreString) {
        String[] gameScores = matchScoreString.split(",");
        List<GameScore> matchScore = new ArrayList<>();
        Arrays.stream(gameScores).forEach(gameScoreString -> {
            String[] playerScore = gameScoreString.split("-");
            GameScore gameScore = new GameScore(Integer.valueOf(playerScore[0]), Integer.valueOf(playerScore[1]));

            matchScore.add(gameScore);
        });
        matchManager.setMatchScore(matchScore);
        return this;
    }

    public BDDMatchManagerAssertion givenGameNumber(int gameNumber) {
        matchManager.setGameNumber(gameNumber);
        return this;
    }

    public BDDMatchManagerAssertion thenWinnerIs(int playerNumber) {
        BDDAssertions.then(matchManager.getWinner()).isEqualTo(playerNumber);
        return this;
    }
}
