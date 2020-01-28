package com.kata.fizzbuzz;

import org.junit.Test;
import com.kata.fizzbuzz.assertions.BDDFizzBuzzAssertion;

/**
 * @author Benjamin Socquet-Juglard (dvd3384)
 */
public class FizzBuzzTest {

    @Test
    public void standardNumber() {
        new BDDFizzBuzzAssertion().whenFizzBuzzOf(2).thenResultShouldBe("2");
        new BDDFizzBuzzAssertion().whenFizzBuzzOf(11).thenResultShouldBe("11");
        new BDDFizzBuzzAssertion().whenFizzBuzzOf(17).thenResultShouldBe("17");
        new BDDFizzBuzzAssertion().whenFizzBuzzOf(22).thenResultShouldBe("22");
        new BDDFizzBuzzAssertion().whenFizzBuzzOf(98).thenResultShouldBe("98");
    }

    @Test
    public void multipleOfThree() {
        new BDDFizzBuzzAssertion().givenPrintFizzWhenMultipleOfThree().whenFizzBuzzOf(3).thenResultShouldBe("Fizz");
        new BDDFizzBuzzAssertion().givenPrintFizzWhenMultipleOfThree().whenFizzBuzzOf(99).thenResultShouldBe("Fizz");
        new BDDFizzBuzzAssertion().givenPrintFizzWhenMultipleOfThree().whenFizzBuzzOf(39).thenResultShouldBe("Fizz");
        new BDDFizzBuzzAssertion().givenPrintFizzWhenMultipleOfThree().whenFizzBuzzOf(12).thenResultShouldBe("Fizz");
    }

    @Test
    public void multipleOfFive() {
        new BDDFizzBuzzAssertion().givenPrintBuzzWhenMultipleOfFive().whenFizzBuzzOf(5).thenResultShouldBe("Buzz");
        new BDDFizzBuzzAssertion().givenPrintBuzzWhenMultipleOfFive().whenFizzBuzzOf(20).thenResultShouldBe("Buzz");
        new BDDFizzBuzzAssertion().givenPrintBuzzWhenMultipleOfFive().whenFizzBuzzOf(40).thenResultShouldBe("Buzz");
        new BDDFizzBuzzAssertion().givenPrintBuzzWhenMultipleOfFive().whenFizzBuzzOf(95).thenResultShouldBe("Buzz");
    }

    @Test
    public void multipleOfThreeAndFive() {
        new BDDFizzBuzzAssertion().givenPrintFizzBuzzWhenMultipleOfFiveAndThree().whenFizzBuzzOf(15).thenResultShouldBe("FizzBuzz");
        new BDDFizzBuzzAssertion().givenPrintFizzBuzzWhenMultipleOfFiveAndThree().whenFizzBuzzOf(30).thenResultShouldBe("FizzBuzz");
        new BDDFizzBuzzAssertion().givenPrintFizzBuzzWhenMultipleOfFiveAndThree().whenFizzBuzzOf(45).thenResultShouldBe("FizzBuzz");
        new BDDFizzBuzzAssertion().givenPrintFizzBuzzWhenMultipleOfFiveAndThree().whenFizzBuzzOf(75).thenResultShouldBe("FizzBuzz");
    }

    @Test
    public void containThree() {
        new BDDFizzBuzzAssertion().givenPrintFizzWhenContainsThree().whenFizzBuzzOf(3).thenResultShouldBe("Fizz");
        new BDDFizzBuzzAssertion().givenPrintFizzWhenContainsThree().whenFizzBuzzOf(43).thenResultShouldBe("Fizz");
        new BDDFizzBuzzAssertion().givenPrintFizzWhenContainsThree().whenFizzBuzzOf(13).thenResultShouldBe("Fizz");
        new BDDFizzBuzzAssertion().givenPrintFizzWhenContainsThree().whenFizzBuzzOf(31).thenResultShouldBe("Fizz");
    }

    @Test
    public void containFive() {
        new BDDFizzBuzzAssertion().givenPrintBuzzWhenContainsFive().whenFizzBuzzOf(5).thenResultShouldBe("Buzz");
        new BDDFizzBuzzAssertion().givenPrintBuzzWhenContainsFive().whenFizzBuzzOf(52).thenResultShouldBe("Buzz");
        new BDDFizzBuzzAssertion().givenPrintBuzzWhenContainsFive().whenFizzBuzzOf(59).thenResultShouldBe("Buzz");
        new BDDFizzBuzzAssertion().givenPrintBuzzWhenContainsFive().whenFizzBuzzOf(55).thenResultShouldBe("Buzz");
    }

}
