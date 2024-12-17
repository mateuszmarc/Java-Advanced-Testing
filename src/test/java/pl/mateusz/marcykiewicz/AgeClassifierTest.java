package pl.mateusz.marcykiewicz;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.EnumSource;
import pl.mateusz.parametrizedtests.AgeClassifier;
import pl.mateusz.parametrizedtests.AgeGroup;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AgeClassifierTest {

    @ParameterizedTest
    @EnumSource(AgeGroup.class)
    public void testAgeClassification(AgeGroup group) {
//        given
        int age = (group.getMinAge() + group.getMaxAge()) / 2;

//        when
        AgeGroup ageGroupResult = AgeClassifier.classify(age);

//        then
        assertEquals(group, ageGroupResult);
    }

    @ParameterizedTest(name = "age=[0}, expected={1}")
    @CsvFileSource(resources = "/age-data.csv")
    public void testAgeClassification2(int age, String expected) {
//        when
        AgeGroup ageGroupResult = AgeClassifier.classify(age);

//        then
        assertEquals(AgeGroup.valueOf(expected), ageGroupResult);
    }
}
