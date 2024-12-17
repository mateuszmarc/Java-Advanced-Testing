package pl.mateusz.parametrizedtests;

import java.util.Arrays;

public class AgeClassifier {

    public static AgeGroup classify(int age) {
        return Arrays.stream(AgeGroup.values())
                .filter(ageGroup -> age <= ageGroup.getMaxAge() && age >= ageGroup.getMinAge())
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Age out of range"));
    }
}
