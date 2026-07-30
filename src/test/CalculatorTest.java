package test;

import main.Calculator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class CalculatorTest {

    @Test
    void addition_twoPositiveNumber() {
        // Given : la donnée de départ
        double firstNumber = 2;
        double secondNumber = 3;

        // When : on appelle la méthode addition
        double result = Calculator.addition(firstNumber, secondNumber);

        // Then : on s'attend à ce que le résultat soit 5
        // assertEquals compare la valeur attendue (5) à la valeur réellement
        // obtenue (result). Le test échoue automatiquement si elles diffèrent.
        assertEquals(5, result);

    }

    @Test
    void addition_oneNegativeAndOnePositiveNumber(){
        // Given
        double firstNumber = -3;
        double secondNumber = 4;

        // When
        double result = Calculator.addition(firstNumber,secondNumber);

        // Then
        assertEquals(1,result);
    }

    @Test
    void subtraction_twoPositiveNumbers() {
        // Given
        double firstNumber = 5;
        double secondNumber = 3;

        // When
        double result = Calculator.subtraction(firstNumber, secondNumber);

        // Then
        assertEquals(2, result);
    }

    @Test
    void subtraction_resultIsNegative() {
        // Given
        double firstNumber = 2;
        double secondNumber = 5;

        // When
        double result = Calculator.subtraction(firstNumber, secondNumber);

        // Then
        assertEquals(-3, result);
    }

    @Test
    void multiplication_twoPositiveNumbers() {
        // Given
        double firstNumber = 4;
        double secondNumber = 5;

        // When
        double result = Calculator.multiplication(firstNumber, secondNumber);

        // Then
        assertEquals(20, result);
    }

    @Test
    void multiplication_byZero() {
        // Given
        double firstNumber = 42;
        double secondNumber = 0;

        // When
        double result = Calculator.multiplication(firstNumber, secondNumber);

        // Then
        assertEquals(0, result);
    }

    @Test
    void divBy0Test() {
        double result = Calculator.division(2, 0);
        assertEquals("Infinity", String.valueOf(result));
    }

    @Test
    void divBIgNumber() {
        double result = Calculator.division(1, 3);
        assertEquals(0.333, result, 0.001);
    }

    @Test
    void division_notAnInteger() {
        // Given : le piège du typage - 5 / 2 vaut 2 en int mais on travaille
        // ici avec des double, donc le résultat garde sa partie décimale.
        double firstNumber = 5;
        double secondNumber = 2;

        // When
        double result = Calculator.division(firstNumber, secondNumber);

        // Then : une tolérance est nécessaire pour éviter les pièges d'arrondi
        // des nombres à virgule flottante.
        assertEquals(2.5, result, 0.0001);
    }

    @Test
    void sumAtoB_ascendingOrder() {
        // Given
        double firstNumber = 2;
        double secondNumber = 5;

        // When
        double result = Calculator.sumAtoB(firstNumber, secondNumber);

        // Then : 2 + 3 + 4 + 5 = 14
        assertEquals(14, result);
    }

    @Test
    void sumAtoB_descendingOrder() {
        // Given : les arguments sont passés dans l'ordre inverse
        double firstNumber = 5;
        double secondNumber = 2;

        // When
        double result = Calculator.sumAtoB(firstNumber, secondNumber);

        // Then : le résultat doit être le même que dans l'ordre ascendant
        assertEquals(14, result);
    }

    @Test
    void sumAtoB_equalBounds() {
        // Given : cas limite où a et b sont égaux
        double firstNumber = 4;
        double secondNumber = 4;

        // When
        double result = Calculator.sumAtoB(firstNumber, secondNumber);

        // Then : la somme de 4 à 4 vaut 4
        assertEquals(4, result);
    }

}
