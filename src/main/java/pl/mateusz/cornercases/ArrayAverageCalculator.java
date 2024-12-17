package pl.mateusz.cornercases;

public class ArrayAverageCalculator {

    public double calculateAverage(int[] array) {
        if (array.length == 0) {
            throw new IllegalArgumentException("Array is empty. Cannot calculate average");
        }

        double sum = 0;

        for (int number : array) {
            sum += number;
        }

        return sum / array.length;
    }
}
