package com.kata.tennis;

import org.junit.Test;
import com.kata.tennis.assertion.BDDMatchManagerAssertion;

/**
 * @author Benjamin Socquet-Juglard (dvd3384)
 */
public class MatchManagerTest {

    @Test
    public void playerWinASet() {
        new BDDMatchManagerAssertion().givenCurrentGameScore(0, 0)//
                                      .givenCurrentSetScore(40, 0)//
                                      .whenFirstPlayerScore()//
                                      .thenCurrentSetScore(0, 0)//
                                      .thenCurrentGameScore(1, 0)//
                                      .thenMatchScore("1-0,0-0,0-0");

        new BDDMatchManagerAssertion().givenCurrentGameScore(0, 0)//
                                      .givenCurrentSetScore(40, 40)//
                                      .givenAdvantagePlayer(1).whenFirstPlayerScore()//
                                      .thenCurrentSetScore(0, 0)//
                                      .thenCurrentGameScore(1, 0)//
                                      .thenMatchScore("1-0,0-0,0-0");

        new BDDMatchManagerAssertion().givenCurrentGameScore(2, 0)//
                                      .givenCurrentSetScore(40, 0)//
                                      .whenFirstPlayerScore()//
                                      .thenCurrentSetScore(0, 0)//
                                      .thenCurrentGameScore(3, 0)//
                                      .thenMatchScore("3-0,0-0,0-0");
    }

    @Test
    public void playerWinAGame() {
        new BDDMatchManagerAssertion().givenCurrentGameScore(5, 0)//
                                      .givenCurrentSetScore(40, 0)//
                                      .whenFirstPlayerScore()//
                                      .thenCurrentGameScore(0, 0)//
                                      .thenMatchScore("6-0,0-0,0-0");

        new BDDMatchManagerAssertion().givenCurrentGameScore(6, 5)//
                                      .givenCurrentSetScore(40, 0)//
                                      .whenFirstPlayerScore()//
                                      .thenCurrentGameScore(0, 0)//
                                      .thenMatchScore("7-5,0-0,0-0");
    }

    @Test
    public void playerWinMatch() {

        new BDDMatchManagerAssertion().givenMatchScore("6-4,0-4,6-5")//
                                      .givenGameNumber(2)//
                                      .givenCurrentGameScore(6, 5)//
                                      .givenCurrentSetScore(40, 0)//
                                      .whenFirstPlayerScore()//
                                      .thenCurrentGameScore(0, 0)//
                                      .thenMatchScore("6-4,0-4,7-5").thenWinnerIs(1);

    }

}
