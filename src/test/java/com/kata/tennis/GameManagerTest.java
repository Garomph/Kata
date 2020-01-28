package com.kata.tennis;

import org.junit.Test;
import com.kata.tennis.assertion.BDDGameManagerAssertion;

/**
 * @author Benjamin Socquet-Juglard (dvd3384)
 */
public class GameManagerTest {

    @Test
    public void playerWinAPoint() {
        new BDDGameManagerAssertion().givenBaseScoreOf(0, 0).whenFirstPlayerWinASet().thenScoreIs(1, 0).thenGameContinue();

        new BDDGameManagerAssertion().givenBaseScoreOf(1, 0).whenFirstPlayerWinASet().thenScoreIs(2, 0).thenGameContinue();

        new BDDGameManagerAssertion().givenBaseScoreOf(1, 0).whenSecondPlayerWinASet().thenScoreIs(1, 1).thenGameContinue();
    }

    @Test
    public void playerWinTheGame() {
        new BDDGameManagerAssertion().givenBaseScoreOf(5, 0).whenFirstPlayerWinASet().thenScoreIs(6, 0).thenFirstPlayerHasWon();

        new BDDGameManagerAssertion().givenBaseScoreOf(2, 5).whenSecondPlayerWinASet().thenScoreIs(2, 6).thenSecondPlayerHasWon();
    }

    @Test
    public void playerMustHaveTwoOrMorePointOfDifference() {
        new BDDGameManagerAssertion().givenBaseScoreOf(5, 5).whenFirstPlayerWinASet().thenScoreIs(6, 5).thenGameContinue();

        new BDDGameManagerAssertion().givenBaseScoreOf(6, 5).whenSecondPlayerWinASet().thenScoreIs(6, 6).thenGameContinue();

        new BDDGameManagerAssertion().givenBaseScoreOf(5, 5).whenFirstPlayerWinASet().thenScoreIs(6, 5).thenGameContinue();

        new BDDGameManagerAssertion().givenBaseScoreOf(6, 5).whenFirstPlayerWinASet().thenScoreIs(7, 5).thenFirstPlayerHasWon();
    }

    @Test
    public void ScoreWillNotChangeIfGameHasBeenWon() {

        new BDDGameManagerAssertion().givenBaseScoreOf(6, 0)
                                     .givenGameHasBeenWonByPlayer(1)
                                     .whenFirstPlayerWinASet()
                                     .thenScoreIs(6, 0)
                                     .thenFirstPlayerHasWon();
    }

}
