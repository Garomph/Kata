package com.kata.tennis;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import com.kata.tennis.modele.GameScore;
import com.kata.tennis.modele.SetScore;
import javafx.util.Pair;

/**
 * @author Benjamin Socquet-Juglard (dvd3384)
 */
public class MatchManager {

    private final GameManager gameManager;
    private final SetManager setManager;
    private List<GameScore> gameScores;
    private int gameNumber;
    private final int gameLimit;
    private Integer winner;

    public MatchManager() {
        gameManager = new GameManager();
        setManager = new SetManager();
        gameScores = new ArrayList<>();
        gameNumber = 0;
        gameLimit = 3;
        winner = null;
        initMatchScore();
    }

    private void initMatchScore() {
        for (int i = 0; i < gameLimit; i++) {
            gameScores.add(new GameScore());
        }
    }

    public void setGameScore(int gameScoreFirstPlayer, int gameScoreSecondPlayer) {
        gameManager.setScore(new GameScore(gameScoreFirstPlayer, gameScoreSecondPlayer));
    }

    public void setSetScore(int setScoreFirstPlayer, int setScoreSecondPlayer) {
        setManager.setSetScore(new Pair<>(SetScore.fromValue(setScoreFirstPlayer), SetScore.fromValue(setScoreSecondPlayer)));

    }

    public void setAdvantagePlayer(int playerNumber) {
        setManager.setPlayerAdvantage(playerNumber);
    }

    public void playerScore(int playerNumber) {
        if (winner != null) {
            return;
        }

        setManager.pointScoreByPlayer(playerNumber);
        if (setManager.getSetWinner() != null) {
            incrementGame(setManager.getSetWinner());
            resetSetManager();
        }
    }

    private void incrementGame(Integer setWinner) {
        gameManager.playerWinAPoint(setWinner);

        gameScores.remove(gameNumber);
        gameScores.add(gameNumber, gameManager.getScore());

        if (gameManager.getWinner() != null) {
            resetGameManager();
            gameNumber++;
        }

        if (gameNumber == gameLimit) {
            calculateWinner();
        }
    }

    private void calculateWinner() {
        winner = gameScores.stream()
                           .collect(Collectors.groupingBy(a -> a.getScoreFirstPlayer() > a.getScoreSecondPlayer() ? 1 : 2, Collectors.counting()))
                           .entrySet()
                           .stream()
                           .max(Map.Entry.comparingByValue())
                           .map(Map.Entry::getKey)
                           .orElse(null);
    }

    private void resetGameManager() {
        gameManager.setScore(new GameScore());
        gameManager.setWinner(null);
    }

    private void resetSetManager() {
        setManager.setSetScore(new Pair<>(SetScore.LOVE, SetScore.LOVE));
        setManager.setPlayerAdvantage(null);
        setManager.setSetWinner(null);
    }

    public String getSetScore() {
        Pair<SetScore, SetScore> setScore = setManager.getSetScore();
        return "(" + setScore.getKey().getPoint() + "-" + setScore.getValue().getPoint() + ")";
    }

    public String getGameScore() {
        GameScore gameScore = gameManager.getScore();
        return gameScore.getScoreFirstPlayer() + "-" + gameScore.getScoreSecondPlayer();
    }

    public String getMatchScore() {
        return gameScores.stream().map(a -> a.getScoreFirstPlayer() + "-" + a.getScoreSecondPlayer()).collect(Collectors.joining(","));
    }

    public void setMatchScore(List<GameScore> matchScore) {
        gameScores = matchScore;
    }

    public void setGameNumber(int gameNumber) {
        this.gameNumber = gameNumber;
    }

    public Integer getWinner() {
        return winner;
    }
}
