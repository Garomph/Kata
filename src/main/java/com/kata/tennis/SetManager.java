package com.kata.tennis;

import com.kata.tennis.modele.SetScore;
import javafx.util.Pair;

/**
 * @author Benjamin Socquet-Juglard (dvd3384)
 */
public class SetManager {

    private Pair<SetScore, SetScore> setScore;
    private Integer setWinner;
    private Integer playerAdvantage;

    public SetManager() {
        setScore = new Pair<>(SetScore.LOVE, SetScore.LOVE);
    }

    public void setSetScore(final Pair<SetScore, SetScore> setScore) {
        this.setScore = setScore;
    }

    public Pair<SetScore, SetScore> getSetScore() {
        return setScore;
    }

    public void pointScoreByPlayer(final int playerNumber) {
        calculateSetScore(playerNumber);

    }

    private void calculateSetScore(final int playerNumber) {
        if (isSetWon(playerNumber) || isAdvantage(playerNumber)) {
            return;
        }
        if (playerNumber == 1) {
            setScore = new Pair<>(incrementScore(setScore.getKey()), setScore.getValue());
        } else if (playerNumber == 2) {
            setScore = new Pair<>(setScore.getKey(), incrementScore(setScore.getValue()));
        }

    }

    private boolean isAdvantage(final int playerNumber) {
        if (setScore.getKey() == SetScore.FORTY && setScore.getValue() == SetScore.FORTY) {
            if (playerAdvantage == null) {
                playerAdvantage = playerNumber;
            } else {
                playerAdvantage = null;
            }
            return true;
        }
        return false;
    }

    private boolean isSetWon(final int scorer) {

        if (scorer == 1 && setScore.getKey() == SetScore.FORTY && (setScore.getValue() != SetScore.FORTY
                || playerAdvantage != null && scorer == playerAdvantage)) {
            setWinner = 1;
        } else if (scorer == 2 && setScore.getValue() == SetScore.FORTY && (setScore.getKey() != SetScore.FORTY
                || playerAdvantage != null && scorer == playerAdvantage)) {
            setWinner = 2;
        }

        return setWinner != null;
    }

    private SetScore incrementScore(final SetScore setScore) {
        SetScore setScoreIncrement = setScore;
        switch (setScore) {
            case LOVE:
                setScoreIncrement = SetScore.FIFTEEN;
                break;
            case FIFTEEN:
                setScoreIncrement = SetScore.THIRTY;
                break;
            case THIRTY:
                setScoreIncrement = SetScore.FORTY;
                break;
            default:
                break;
        }
        return setScoreIncrement;
    }

    public Integer getSetWinner() {
        return setWinner;
    }

    public Integer getPlayerAdvantage() {
        return playerAdvantage;
    }

    public void setPlayerAdvantage(Integer playerNumber) {
        playerAdvantage = playerNumber;
    }

    public void setSetWinner(Integer playerNumber) {
        setWinner = playerNumber;
    }
}
