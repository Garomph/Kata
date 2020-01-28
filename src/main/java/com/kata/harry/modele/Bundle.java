package com.kata.harry.modele;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Benjamin Socquet-Juglard (dvd3384)
 */
public class Bundle {

    private final List<List<String>> bundles;


    public Bundle() {
        bundles = new ArrayList<>();
    }

    public boolean add(String book) {
        boolean isAdded = false;
        for (List<String> lot : bundles) {
            if (!lot.contains(book) && !isAdded) {
                isAdded = lot.add(book);
            }
        }
        if (!isAdded) {
            List<String> list = new ArrayList<>();
            list.add(book);
            bundles.add(list);
        }

        return true;
    }


    public List<List<String>> getBundles() {
        return bundles;
    }

    public void optimizeBundles() {
        List<String> bundleOfFive = null;
        List<String> bundleOfThree = null;

        for (List<String> bundle : bundles) {
            if (bundle.size() == 5) {
                bundleOfFive = bundle;
            } else if (bundle.size() == 3) {
                bundleOfThree = bundle;
            }
        }

        if (bundleOfFive != null && bundleOfThree != null) {
            bundleOfThree.add(bundleOfFive.get(0));
            bundleOfFive.remove(bundleOfFive.get(0));
            optimizeBundles();
        }
    }
}
