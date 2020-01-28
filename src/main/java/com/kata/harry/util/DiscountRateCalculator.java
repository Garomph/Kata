package com.kata.harry.util;

/**
 * @author Benjamin Socquet-Juglard (dvd3384)
 */
public class DiscountRateCalculator {

    public static double getDiscountRate(final int numberOfDistinctBooks) {
        switch (numberOfDistinctBooks) {
            case 2:
                return 0.05;
            case 3:
                return 0.1;
            case 4:
                return 0.20;
            case 5:
                return 0.25;
            default:
                return 0.;
        }
    }
}
