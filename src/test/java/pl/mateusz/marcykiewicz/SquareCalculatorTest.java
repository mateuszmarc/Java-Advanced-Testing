package pl.mateusz.marcykiewicz;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import pl.mateusz.parametrizedtests.SquareCalculator;
import pl.mateusz.parametrizedtests.SquareScenario;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SquareCalculatorTest {

    @ParameterizedTest
    @EnumSource(SquareScenario.class)
    public void testSquare(SquareScenario squareScenario) {
        assertEquals(squareScenario.getExpectedOutput(), SquareCalculator.square(squareScenario.getInput()));
    }
}
