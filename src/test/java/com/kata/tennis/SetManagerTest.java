package com.kata.tennis;

import org.junit.Test;
import com.kata.tennis.assertion.BDDSetManagerAssertion;

/**
 * @author Benjamin Socquet-Juglard (dvd3384)
 */
public class SetManagerTest {

    @Test
    public void playerScoreAPoint() {
        new BDDSetManagerAssertion().givenBaseSetScoreOf(0, 0).whenFirstPlayerWinAPoint().thenSetScoreIs(15, 0).thenSetContinue();

        new BDDSetManagerAssertion().givenBaseSetScoreOf(15, 0).whenFirstPlayerWinAPoint().thenSetScoreIs(30, 0).thenSetContinue();

        new BDDSetManagerAssertion().givenBaseSetScoreOf(15, 15).whenSecondPlayerWinAPoint().thenSetScoreIs(15, 30).thenSetContinue();

        new BDDSetManagerAssertion().givenBaseSetScoreOf(15, 30).whenSecondPlayerWinAPoint().thenSetScoreIs(15, 40).thenSetContinue();
    }

    @Test
    public void playerWinASet() {

        new BDDSetManagerAssertion().givenBaseSetScoreOf(40, 30).whenFirstPlayerWinAPoint().thenSetScoreIs(40, 30).thenFirstPlayerWon();

        new BDDSetManagerAssertion().givenBaseSetScoreOf(0, 40).whenSecondPlayerWinAPoint().thenSetScoreIs(0, 40).thenSecondPlayerWon();
    }

    @Test
    public void playerGetAdvantage() {

        new BDDSetManagerAssertion().givenBaseSetScoreOf(40, 40)
                                    .whenFirstPlayerWinAPoint()
                                    .thenSetScoreIs(40, 40)
                                    .thenPlayerHasAdvantage(1)
                                    .thenSetContinue();

        new BDDSetManagerAssertion().givenBaseSetScoreOf(40, 40)
                                    .givenAdvantagePlayer(2)
                                    .whenFirstPlayerWinAPoint()
                                    .thenSetScoreIs(40, 40)
                                    .thenNoAdvantage()
                                    .thenSetContinue();

        new BDDSetManagerAssertion().givenBaseSetScoreOf(40, 40)
                                    .givenAdvantagePlayer(1)
                                    .whenFirstPlayerWinAPoint()
                                    .thenSetScoreIs(40, 40)
                                    .thenFirstPlayerWon();
    }

}
