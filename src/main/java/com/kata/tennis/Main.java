package com.kata.tennis;

import java.util.Random;

/**
 * @author Benjamin Socquet-Juglard (dvd3384)
 */
public class Main {

    private static MatchManager matchManager;
    private static Random random;

    public static final void main(String[] args) {
        matchManager = new MatchManager();
        random = new Random();

        while (matchManager.getWinner() == null) {
            playAPoint();
        }

        System.out.println(matchManager.getMatchScore());
        System.out.println("Player " + matchManager.getWinner() + " won.");

    }

    private static void playAPoint() {
        matchManager.playerScore(random.nextInt(2) + 1);
    }

}
