package pl.mateusz.marcykiewicz;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.mateusz.exceptiontesting.Calc;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
}
