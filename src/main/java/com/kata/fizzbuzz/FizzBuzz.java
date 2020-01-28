package com.kata.fizzbuzz;

import org.apache.commons.lang3.StringUtils;

/**
 * @author Benjamin Socquet-Juglard (dvd3384)
 */
public class FizzBuzz {

    public String fizzBuzzNumber(int number) {

        String result = "";

        if (number % 3 == 0 || String.valueOf(number).contains(String.valueOf(3))) {
            result = "Fizz";
        }
        if (number % 5 == 0 || String.valueOf(number).contains(String.valueOf(5))) {
            result += "Buzz";
        }

        return StringUtils.isNotBlank(result) ? result : String.valueOf(number);
    }
}
