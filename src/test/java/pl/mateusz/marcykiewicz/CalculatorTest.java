package pl.mateusz.marcykiewicz;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.mateusz.marcykiewicz.testingintroduction.Calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

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


}
