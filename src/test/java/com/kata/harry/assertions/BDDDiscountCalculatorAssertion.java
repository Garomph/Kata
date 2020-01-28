package com.kata.harry.assertions;

import com.kata.harry.DiscountCalculator;
import org.assertj.core.api.BDDAssertions;

import java.util.List;

/**
 * @author Benjamin Socquet-Juglard (dvd3384)
 */
public class BDDDiscountCalculatorAssertion {

    private final DiscountCalculator discountCalculator;
    private double totalPrice;

    public BDDDiscountCalculatorAssertion() {
        discountCalculator = new DiscountCalculator();
    }

    public BDDDiscountCalculatorAssertion givenBookPrice(final int price) {
        discountCalculator.setBookPrice(price);
        return this;
    }

    public BDDDiscountCalculatorAssertion whenBuyListOfBook(final List<String> books) {
        totalPrice = discountCalculator.calculateDiscount(books);
        return this;
    }

    public BDDDiscountCalculatorAssertion thenTotalPriceIs(final double totalPrice) {
        BDDAssertions.then(this.totalPrice).isEqualTo(totalPrice);
        return this;
    }
}
