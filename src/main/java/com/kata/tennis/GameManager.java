package com.kata.tennis;

import com.kata.tennis.modele.GameScore;

/**
 * @author Benjamin Socquet-Juglard (dvd3384)
 */
public class GameManager {

    private static final int WINNING_POINT = 6;

    private GameScore score;

    public GameManager() {
        score = new GameScore();
    }

    public void setScore(final GameScore score) {
        this.score = score;
    }

    public void playerWinAPoint(final int playerNumber) {
        if (score.getWinner() == null) {
            countScore(playerNumber);

            checkWinner();
        }
    }

    private void checkWinner() {
        if ((score.getScoreFirstPlayer() >= WINNING_POINT || score.getScoreSecondPlayer() >= WINNING_POINT)
                && Math.abs(score.getScoreFirstPlayer() - score.getScoreSecondPlayer()) >= 2) {
            score.setWinner(score.getScoreFirstPlayer() > score.getScoreSecondPlayer() ? 1 : 2);
        }
    }

    private void countScore(final int playerNumber) {
        if (playerNumber == 1) {
            score.setScoreFirstPlayer(score.getScoreFirstPlayer() + 1);
        } else {
            score.setScoreSecondPlayer(score.getScoreSecondPlayer() + 1);
        }
    }

    public GameScore getScore() {
        return score;
    }

    public Integer getWinner() {
        return score.getWinner();
    }

    public void setWinner(final Integer playerNumber) {
        score.setWinner(playerNumber);
    }
}
