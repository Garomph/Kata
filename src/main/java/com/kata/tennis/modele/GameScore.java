package com.kata.tennis.modele;

import java.util.Objects;

/**
 * @author Benjamin Socquet-Juglard (dvd3384)
 */
public class GameScore {

    private int scoreFirstPlayer;
    private int scoreSecondPlayer;
    private Integer winner;

    public GameScore() {
        scoreFirstPlayer = 0;
        scoreSecondPlayer = 0;
        winner = null;
    }

    public GameScore(Integer firstPlayerScore, Integer secondPlayerScore) {
        scoreFirstPlayer = firstPlayerScore;
        scoreSecondPlayer = secondPlayerScore;
        winner = null;
    }

    public int getScoreFirstPlayer() {
        return scoreFirstPlayer;
    }

    public void setScoreFirstPlayer(int scoreFirstPlayer) {
        this.scoreFirstPlayer = scoreFirstPlayer;
    }

    public int getScoreSecondPlayer() {
        return scoreSecondPlayer;
    }

    public void setScoreSecondPlayer(int scoreSecondPlayer) {
        this.scoreSecondPlayer = scoreSecondPlayer;
    }

    public Integer getWinner() {
        return winner;
    }

    public void setWinner(Integer winner) {
        this.winner = winner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GameScore gameScore = (GameScore) o;
        return scoreFirstPlayer == gameScore.scoreFirstPlayer && scoreSecondPlayer == gameScore.scoreSecondPlayer;
    }

    @Override
    public int hashCode() {
        return Objects.hash(scoreFirstPlayer, scoreSecondPlayer);
    }
}
