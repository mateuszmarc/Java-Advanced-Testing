package pl.mateusz.marcykiewicz;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import pl.mateusz.parametrizedtests.Numbers;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumbersTest {

    @ParameterizedTest(name = "number={0}, expected={1}")
    @CsvFileSource(resources = "/numbers.csv")
    public void testCheckParity(int number, String expected) {
        assertEquals(expected, Numbers.checkParity(number));
    }

    @ParameterizedTest(name = "number={0}, expected={1}")
    @CsvSource({
            "-1, odd",
            "0, zero",
            "1, odd",
            "2, even",
            "100, even"
    })
    public void testCheckParity2(int number, String expected) {
        assertEquals(expected, Numbers.checkParity(number));
    }

    public static Stream<Arguments> getParityArguments() {
        return Stream.of(
                Arguments.of(-1, "odd"),
                Arguments.of(0, "zero"),
                Arguments.of(2, "even")
        );
    }

    @ParameterizedTest(name = "number={0}, expected={1}")
    @MethodSource("getParityArguments")
    public void testCheckParity3(int number, String expected) {
        assertEquals(expected, Numbers.checkParity(number));
    }
}
