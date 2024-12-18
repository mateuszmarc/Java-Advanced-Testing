package pl.mateusz.marcykiewicz;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.mateusz.exceptiontesting.Calc;
import pl.mateusz.exceptiontesting.NegativeNumberException;

import static org.junit.jupiter.api.Assertions.*;

public class CalcTest {

    @Test
    @DisplayName("Should throw IllegalArgumentException when passing number smaller than zero")
    public void givenCalc_whenCalculateFactorialFromNegativeNumber_thenThrowIllegalArgumentException() {

//   given & when & then
        assertThrows(IllegalArgumentException.class, () -> Calc.factorial(-1));
    }

    @Test
    @DisplayName("Should not throw IllegalArgumentException when passing number greater than zero")
    public void givenCalc_whenCalculateFactorialFromPositiveNumber_thenNotThrowIllegalArgumentException() {

//   given & when & then
        assertDoesNotThrow(() -> Calc.factorial(1));
    }

    @Test
    @DisplayName("When passing negative number to calculateSquare should throw NegativeNumberException")
    void givenCalc_whenPassingNegativeNumberToCalculateSquare_thenThrowNegativeNumberException() {

//        when
        NegativeNumberException exception =  assertThrows(NegativeNumberException.class, () -> Calc.calculateSquare(-1));
        assertEquals("You cannot calculate square from number -1", exception.getMessage());
    }
}
