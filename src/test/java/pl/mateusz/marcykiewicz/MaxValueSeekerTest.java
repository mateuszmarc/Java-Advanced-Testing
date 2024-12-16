package pl.mateusz.marcykiewicz;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.mateusz.marcykiewicz.testingintroduction.MaxValueSeeker;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MaxValueSeekerTest {

    @Test
    @DisplayName("Check getMaxValue method")
    void testShouldReturnMaxValue() {
        int[] integers = {1, 2, 3, 4};

        int expected = 4;

        assertEquals(expected, MaxValueSeeker.getMaxValue(integers));
    }

    @Test
    @DisplayName("Check getMaxValue method for max number in the middle of the array")
    void testShouldReturnMaxValueFromTheMiddleOfArray() {
        int[] integers = {1, 2, 8, 3, 4};

        int expected = 8;

        assertEquals(expected, MaxValueSeeker.getMaxValue(integers));
    }

    @Test
    @DisplayName("Check getMaxValue method for array with the same numbers")
    void testShouldReturnMaxValueForArrayWithTheSameNumbers() {
        int[] integers = {1, 1, 1, 1};

        int expected = 1;

        assertEquals(expected, MaxValueSeeker.getMaxValue(integers));
    }

    @Test
    @DisplayName("Check getMaxValue method for array with on number")
    void testShouldReturnMaxValueForArrayWithOneNumber() {
        int[] integers = {1};

        int expected = 1;

        assertEquals(expected, MaxValueSeeker.getMaxValue(integers));
    }

    @Test
    @DisplayName("Check getMaxValue method for array with negative numbers")
    void testShouldReturnMaxValueForArrayWithNegativeNumbers() {
        int[] integers = {-4, -5, -7, -9};

        int expected = -4;

        assertEquals(expected, MaxValueSeeker.getMaxValue(integers));
    }

    @Test
    @DisplayName("Check for null array passed")
    void testShouldThrowExceptionForNullArray() {

        assertThrows(IllegalArgumentException.class, () -> MaxValueSeeker.getMaxValue(null));
    }

    @Test
    @DisplayName("Check max value for empty array")
    void testShouldThrowExceptionForEmptyArray() {
        assertThrows (IllegalArgumentException.class, () -> MaxValueSeeker.getMaxValue(new int[]{}));
    }

}
