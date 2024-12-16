package pl.mateusz.marcykiewicz;

import java.util.Arrays;

public class MaxValueSeeker {
    public static int getMaxValue(int[] integers) {

        if (integers == null) {
            throw  new IllegalArgumentException("Passed array is null");
        }

        return Arrays.stream(integers).max().orElseThrow(() -> new IllegalArgumentException("Empty list"));
    }
}
