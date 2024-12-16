package pl.mateusz.marcykiewicz;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.mateusz.marcykiewicz.testingintroduction.Calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    public void setup() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("Should return 0 on two 0 parameters")
    void testAddShouldReturnZeroOnTwoZeroParameters() {

        assertEquals(0, calculator.add(0,0));
    }

    @Test
    @DisplayName("Test add method with negative parameters")
    void testAssWithNegativeNumbers() {
        assertEquals(-5, calculator.add(-4, -1));
    }

    @Test
    @DisplayName("Test add method with first negative parameter")
    void testAddWithFirstNegativeParameter() {
        assertEquals(-5, calculator.add(-6, 1));
    }

    @Test
    @DisplayName("Test add method with second negative parameter")
    void testAddWithSecondNegativeParameter() {
        assertEquals(5, calculator.add(6, -1));
    }

    @Test
    @DisplayName("Test add method for first argument being max value and second greater than 0")
    void testAddForFirstParameterBeingMaxIntegerValueAndSecondGreaterThanZero() {

        int a = Integer.MAX_VALUE;
        int b = 1;

        assertThrows(ArithmeticException.class, () -> calculator.add(a, b));
    }

    @Test
    @DisplayName("Test add method for first argument being greater than 0 and second being integer max value")
    void testAddForFirstParameterBeingGreaterThanZeroAndSecondIntegerMaxValue() {

        int a = 1;
        int b = Integer.MAX_VALUE;

        assertThrows(ArithmeticException.class, () -> calculator.add(a, b));
    }

    @Test
    @DisplayName("Test add method for first argument being smaller than 0 and second being integer min value")
    void testAddForFirstParameterBeingSmallerThanZeroAndSecondIntegerMinValue() {

        int a = -1;
        int b = Integer.MIN_VALUE;

        assertThrows(ArithmeticException.class, () -> calculator.add(a, b));
    }

    @Test
    @DisplayName("Test add method for first argument being smaller than 0 and second being integer min value")
    void testAddForFirstParameterIntegerMinValueAndSecondBeingSmallerThanZero() {

        int a = Integer.MIN_VALUE;
        int b = -1;

        assertThrows(ArithmeticException.class, () -> calculator.add(a, b));
    }

}
