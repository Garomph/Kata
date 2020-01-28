package com.kata.tennis.assertion;

import static org.assertj.core.api.BDDAssertions.then;

import com.kata.tennis.SetManager;
import com.kata.tennis.modele.SetScore;
import javafx.util.Pair;

/**
 * @author Benjamin Socquet-Juglard (dvd3384)
 */
public class BDDSetManagerAssertion {

    private final SetManager setManager;

    public BDDSetManagerAssertion() {
        setManager = new SetManager();
    }

    public BDDSetManagerAssertion givenBaseSetScoreOf(final int setScoreFirstPlayer, final int setScoreSecondPlayer) {
        setManager.setSetScore(new Pair<>(SetScore.fromValue(setScoreFirstPlayer), SetScore.fromValue(setScoreSecondPlayer)));

        return this;
    }

    public BDDSetManagerAssertion givenAdvantagePlayer(final int playerNumber) {
        setManager.setPlayerAdvantage(playerNumber);
        return this;
    }

    public BDDSetManagerAssertion whenFirstPlayerWinAPoint() {
        setManager.pointScoreByPlayer(1);
        return this;
    }

    public BDDSetManagerAssertion whenSecondPlayerWinAPoint() {
        setManager.pointScoreByPlayer(2);
        return this;
    }

    public BDDSetManagerAssertion thenSetScoreIs(final int setScoreFirstPlayer, final int setScoreSecondPlayer) {
        then(setManager.getSetScore()).isEqualTo(new Pair<>(SetScore.fromValue(setScoreFirstPlayer), SetScore.fromValue(setScoreSecondPlayer)));
        return this;
    }

    public BDDSetManagerAssertion thenSetContinue() {
        then(setManager.getSetWinner()).isNull();
        return this;
    }

    public BDDSetManagerAssertion thenFirstPlayerWon() {
        then(setManager.getSetWinner()).isEqualTo(1);
        return this;
    }

    public BDDSetManagerAssertion thenSecondPlayerWon() {
        then(setManager.getSetWinner()).isEqualTo(2);
        return this;
    }

    public BDDSetManagerAssertion thenPlayerHasAdvantage(final int playerNumber) {
        then(setManager.getPlayerAdvantage()).isEqualTo(playerNumber);
        return this;
    }

    public BDDSetManagerAssertion thenNoAdvantage() {
        then(setManager.getPlayerAdvantage()).isNull();
        return this;
    }
}
