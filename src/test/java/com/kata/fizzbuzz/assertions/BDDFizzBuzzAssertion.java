package com.kata.fizzbuzz.assertions;

import org.assertj.core.api.BDDAssertions;
import com.kata.fizzbuzz.FizzBuzz;

/**
 * @author Benjamin Socquet-Juglard (dvd3384)
 */
public class BDDFizzBuzzAssertion {

    private final FizzBuzz fizzBuzz;
    private String result;

    public BDDFizzBuzzAssertion() {
        fizzBuzz = new FizzBuzz();
    }

    public BDDFizzBuzzAssertion givenPrintFizzWhenContainsThree() {
        return this;
    }

    public BDDFizzBuzzAssertion givenPrintBuzzWhenContainsFive() {
        return this;
    }

    public BDDFizzBuzzAssertion givenPrintFizzBuzzWhenMultipleOfFiveAndThree() {
        return this;
    }

    public BDDFizzBuzzAssertion givenPrintFizzWhenMultipleOfThree() {
        return this;
    }

    public BDDFizzBuzzAssertion givenPrintBuzzWhenMultipleOfFive() {
        return this;
    }

    public BDDFizzBuzzAssertion whenFizzBuzzOf(int number) {
        result = fizzBuzz.fizzBuzzNumber(number);
        return this;
    }

    public BDDFizzBuzzAssertion thenResultShouldBe(String resultatAttendu) {
        BDDAssertions.then(result).isEqualTo(resultatAttendu);
        return this;
    }
}
