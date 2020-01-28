package com.kata.tennis.modele;

import java.util.Arrays;

/**
 * @author Benjamin Socquet-Juglard (dvd3384)
 */
public enum SetScore {
    LOVE(0), FIFTEEN(15), THIRTY(30), FORTY(40), ADVANTAGE(99);

    private final int point;

    SetScore(final int point) {
        this.point = point;
    }

    public static SetScore fromValue(final int value) {
        return Arrays.stream(SetScore.values()).filter(a -> a.getPoint() == value).findFirst().orElse(null);
    }

    public int getPoint() {
        return point;
    }
}
