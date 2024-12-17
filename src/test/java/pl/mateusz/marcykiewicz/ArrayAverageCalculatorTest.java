package pl.mateusz.marcykiewicz;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.mateusz.cornercases.ArrayAverageCalculator;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ArrayAverageCalculatorTest {

    private ArrayAverageCalculator arrayAverageCalculator;

    @BeforeEach
    public void setup() {
        arrayAverageCalculator = new ArrayAverageCalculator();
    }

    @Test
    @DisplayName("Should throw Exception on empty array")
    public void givenEmptyArray_whenCalculateAverage_thenThrowIllegalArgumentException() {
//        given
        int[] array = new int[]{};

//        then
        assertThrows(IllegalArgumentException.class, () -> arrayAverageCalculator.calculateAverage(array));
    }

    @Test
    @DisplayName("Should throw Exception on null array")
    public void givenNullArray_whenCalculateAverage_thenThrowIllegalArgumentException() {
//        given
        int[] array = null;

//        then
        assertThrows(IllegalArgumentException.class, () -> arrayAverageCalculator.calculateAverage(array));
    }

    @Test
    @DisplayName("Should return 0 on array of zeros")
    public void givenArrayOfZeros_whenCalculateAverage_thenReturnZero() {
//        given
        int[] array = {0, 0, 0, 0, 0};

//        when
        double average = arrayAverageCalculator.calculateAverage(array);

//        then
        assertEquals(0, average);
    }

    @Test
    @DisplayName("Should return result on full array")
    public void givenArray_whenCalculateAverage_thenReturnResult() {
//        given
        int[] array = {5, 6, 7, 2, 5, 9};

//        when
        double average = arrayAverageCalculator.calculateAverage(array);
        double expected =  Arrays.stream(array).sum() / (double) array.length;

//        then
        assertEquals(expected, average);
    }

    @Test
    @DisplayName("Should return result for array with one number")
    public void givenArrayWithOneNumber_whenCalculateAverage_thenReturnResult() {
//        given
        int[] array = {5};

//        when
        double average = arrayAverageCalculator.calculateAverage(array);
        double expected =  5.0;

//        then
        assertEquals(expected, average);
    }

    @Test
    @DisplayName("Should return Integer max value as double when passing array of Integer max values")
    public void givenArrayOnIntegerMaxValues_whenCalculateAverage_thenReturnIntegerMaxValueAsDouble() {
        //        given
        int[] array = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};

//        when
        double average = arrayAverageCalculator.calculateAverage(array);
        double expected = Integer.MAX_VALUE;

//        then
        assertEquals(expected, average);
    }

    @Test
    @DisplayName("Should return Integer max value as double when passing array of Integer max values")
    public void givenArrayOnIntegerMinValues_whenCalculateAverage_thenReturnIntegerMinValueAsDouble() {
        //        given
        int[] array = {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};

//        when
        double average = arrayAverageCalculator.calculateAverage(array);
        double expected = Integer.MIN_VALUE;

//        then
        assertEquals(expected, average);
    }
}
