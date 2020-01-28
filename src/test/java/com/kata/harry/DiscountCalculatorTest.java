package com.kata.harry;

import com.kata.harry.assertions.BDDDiscountCalculatorAssertion;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author Benjamin Socquet-Juglard (dvd3384)
 */
public class DiscountCalculatorTest {

    @Test
    public void computePriceWithoutDiscount() {

        new BDDDiscountCalculatorAssertion().givenBookPrice(8)
                .whenBuyListOfBook(Arrays.asList("1"))
                .thenTotalPriceIs(8);

        new BDDDiscountCalculatorAssertion().givenBookPrice(8)
                .whenBuyListOfBook(Arrays.asList("1", "1"))
                .thenTotalPriceIs(16);
    }

    @Test
    public void computePriceWithSimpleDiscount() {

        new BDDDiscountCalculatorAssertion().givenBookPrice(8)
                .whenBuyListOfBook(Arrays.asList("1", "2"))
                .thenTotalPriceIs(15.2);

        new BDDDiscountCalculatorAssertion().givenBookPrice(8)
                .whenBuyListOfBook(Arrays.asList("1", "3", "5"))
                .thenTotalPriceIs(21.6);
    }

    @Test
    public void computePriceForBooksWithAndWithoutDiscount() {

        new BDDDiscountCalculatorAssertion().givenBookPrice(8)
                .whenBuyListOfBook(Arrays.asList("1", "2", "1"))
                .thenTotalPriceIs(23.2);

        new BDDDiscountCalculatorAssertion().givenBookPrice(8)
                .whenBuyListOfBook(Arrays.asList("1", "2", "3", "1", "2"))
                .thenTotalPriceIs(36.8);
    }

    @Test
    public void computeOptimalPrice() {

        new BDDDiscountCalculatorAssertion().givenBookPrice(8)
                .whenBuyListOfBook(Arrays.asList("1", "2", "3", "4", "5", "1", "2", "3"))
                .thenTotalPriceIs(51.2);

        new BDDDiscountCalculatorAssertion().givenBookPrice(8)
                .whenBuyListOfBook(Arrays.asList("1", "2", "3", "4", "5", "1", "2", "3", "1", "2", "3", "4", "5"))
                .thenTotalPriceIs(81.2);
    }


}
