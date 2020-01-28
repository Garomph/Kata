package com.kata.harry;

import com.kata.harry.modele.Bundle;
import com.kata.harry.util.DiscountRateCalculator;

import java.util.HashSet;
import java.util.List;

/**
 * @author Benjamin Socquet-Juglard (dvd3384)
 */
public class DiscountCalculator {

    private int price;


    public double calculateDiscount(final List<String> books) {
        int numberOfBooks = books.size();

        if (isOnlySameBook(books)) {
            return numberOfBooks * price * 1.0;
        }

        Bundle bundle = createLotAndOptimize(books);

        return bundle.getBundles().stream().mapToDouble(lot -> price * lot.size() * (getDiscountRate(lot.size()))).sum();
    }

    private Bundle createLotAndOptimize(final List<String> books) {
        Bundle bundle = createLot(books);
        bundle.optimizeBundles();

        return bundle;
    }


    private Bundle createLot(final List<String> books) {
        Bundle bundle = new Bundle();
        books.forEach(bundle::add);

        return bundle;
    }

    private double getDiscountRate(final int numberOfBooks) {
        return 1 - DiscountRateCalculator.getDiscountRate(numberOfBooks);
    }

    private boolean isOnlySameBook(final List<String> books) {
        return new HashSet<>(books).size() == 1;
    }

    public void setBookPrice(final int price) {
        this.price = price;
    }
}
