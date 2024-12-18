package pl.mateusz.marcykiewicz;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import pl.mateusz.enums.PrimeNumberChecker;
import pl.mateusz.enums.PrimeScenario;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrimeNumberCheckerTest {

    @ParameterizedTest(name = "number={0}, isPrime={1}")
    @EnumSource(PrimeScenario.class)
    public void testIsPrime(PrimeScenario primeScenario) {

        assertEquals(primeScenario.isPrimeNumber(), PrimeNumberChecker.isPrime(primeScenario.getNumber()));
    }
}
