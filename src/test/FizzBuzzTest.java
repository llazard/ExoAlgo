package test;

import main.FizzBuzz;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FizzBuzzTest {

    // Étape 1 du brief Jour 2 : un test par valeur simple, avant l'ajout de
    // la règle Qix.

    @Test
    void fizzBuzz_returnsNumberAsString_whenNotDivisibleByAnyRule() {
        // Given
        int number = 1;

        // When
        String result = FizzBuzz.fizzBuzz(number);

        // Then
        assertEquals("1", result);
    }

    @Test
    void fizzBuzz_returnsQix_whenDivisibleBy2Only() {
        // Given
        int number = 4;

        // When
        String result = FizzBuzz.fizzBuzz(number);

        // Then
        assertEquals("Qix", result);
    }

    @Test
    void fizzBuzz_returnsFizz_whenDivisibleBy3Only() {
        // Given
        int number = 3;

        // When
        String result = FizzBuzz.fizzBuzz(number);

        // Then
        assertEquals("Fizz", result);
    }

    @Test
    void fizzBuzz_returnsBuzz_whenDivisibleBy5Only() {
        // Given
        int number = 5;

        // When
        String result = FizzBuzz.fizzBuzz(number);

        // Then
        assertEquals("Buzz", result);
    }

    @Test
    void fizzBuzz_returnsSeven_whenNotDivisibleByAnyRule() {
        // Given
        int number = 7;

        // When
        String result = FizzBuzz.fizzBuzz(number);

        // Then
        assertEquals("7", result);
    }

    @Test
    void fizzBuzz_returnsFizz_whenDivisibleBy3Only_evenIfOdd() {
        // Given : 9 est divisible par 3 mais pas par 2, donc pas de Qix
        int number = 9;

        // When
        String result = FizzBuzz.fizzBuzz(number);

        // Then
        assertEquals("Fizz", result);
    }

    // Étapes 4 et 5 du brief Jour 2 : ajout de la règle Qix (divisible par 2)
    // et de sa concaténation avec Fizz/Buzz quand plusieurs règles matchent.

    @Test
    void fizzBuzz_returnsFizzQix_whenDivisibleBy3And2() {
        // Given
        int number = 6;

        // When
        String result = FizzBuzz.fizzBuzz(number);

        // Then
        assertEquals("FizzQix", result);
    }

    @Test
    void fizzBuzz_returnsBuzzQix_whenDivisibleBy5And2() {
        // Given
        int number = 10;

        // When
        String result = FizzBuzz.fizzBuzz(number);

        // Then
        assertEquals("BuzzQix", result);
    }

    @Test
    void fizzBuzz_returnsFizzBuzz_whenDivisibleBy3And5() {
        // Given
        int number = 15;

        // When
        String result = FizzBuzz.fizzBuzz(number);

        // Then
        assertEquals("FizzBuzz", result);
    }

    @Test
    void fizzBuzz_returnsFizzBuzzQix_whenDivisibleBy3And5And2() {
        // Given
        int number = 30;

        // When
        String result = FizzBuzz.fizzBuzz(number);

        // Then
        assertEquals("FizzBuzzQix", result);
    }
}
