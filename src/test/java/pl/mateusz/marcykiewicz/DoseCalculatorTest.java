package pl.mateusz.marcykiewicz;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.mateusz.pyramidtesting.DoseCalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DoseCalculatorTest {

    private DoseCalculator doseCalculator;

    @BeforeEach
    void setup() {
        doseCalculator = new DoseCalculator();
    }

    @Test
    @DisplayName("Test calculateYoungDose method for valid double parameters")
    void testCalculateYoungDose() {
        double dose = 200.00;
        double age = 6;

        double expectedResult = dose * (age / (age + 12));

        assertEquals(expectedResult, doseCalculator.calculateYoungDose(dose, age));
    }

    @Test
    @DisplayName("Test calculateYoungDose should throw exception for dose equal to zero")
    void testShouldThrowExceptionForDoseEqualToZero() {
        double dose = 0;
        double age = 6;

        assertThrows(IllegalArgumentException.class, () -> doseCalculator.calculateYoungDose(dose, age));
    }

    @Test
    @DisplayName("Test calculateYoungDose should throw exception for age equal to zero")
    void testShouldThrowExceptionForAgeEqualToZero() {
        double dose = 200;
        double age = 0;

        assertThrows(IllegalArgumentException.class, () -> doseCalculator.calculateYoungDose(dose, age));
    }

    @Test
    @DisplayName("Test calculateYoungDose should throw exception for age and dose equal to zero")
    void testShouldThrowExceptionForAgeAndDoseEqualToZero() {
        double dose = 0;
        double age = 0;

        assertThrows(IllegalArgumentException.class, () -> doseCalculator.calculateYoungDose(dose, age));
    }

    @Test
    @DisplayName("Test calculateYoungDose should throw exception for age greater than 14")
    void testShouldThrowExceptionForAgeGreaterThanFourteen() {
        double dose = 200;
        double age = 15;

        assertThrows(IllegalArgumentException.class, () -> doseCalculator.calculateYoungDose(dose, age));
    }

    @Test
    @DisplayName("Test calculateYoungDose should not throw exception for age equal to 14")
    void testShouldNotThrowExceptionForAgeEqualThanFourteen() {
        double dose = 200;
        double age = 14;

        double expectedResult = dose * (age / (age + 12));

        assertEquals(expectedResult, doseCalculator.calculateYoungDose(dose, age));
    }
}
