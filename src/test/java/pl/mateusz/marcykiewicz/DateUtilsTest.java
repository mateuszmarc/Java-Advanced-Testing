package pl.mateusz.marcykiewicz;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import pl.mateusz.parametrizedtests.DateUtils;

import java.time.DayOfWeek;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DateUtilsTest {

    @ParameterizedTest(name = "dayOfVWeek={0}, expected={1}")
    @CsvFileSource(resources = "/days.csv")
    public void testIsWeekend(String dayOfWeek, boolean expected) {

        assertEquals(expected, DateUtils.isWeekend(DayOfWeek.valueOf(dayOfWeek)));
    }

    @ParameterizedTest(name = "dayOfWeek={0}, expected={1}")
    @CsvSource({
            "MONDAY, false",
            "TUESDAY, false",
            "WEDNESDAY, false",
            "THURSDAY, false",
            "FRIDAY, false",
            "SATURDAY, true",
            "SUNDAY, true",

    })
    public void testIsWeekend2(String dayOfWeek, boolean expected) {
        assertEquals(expected, DateUtils.isWeekend(DayOfWeek.valueOf(dayOfWeek)));

    }

    @ParameterizedTest(name = "dayOfWeek={0}, expected={1}")
    @MethodSource("getDayArguments")
    public void testIsWeekend3(String dayOfWeek, boolean expected) {
        assertEquals(expected, DateUtils.isWeekend(DayOfWeek.valueOf(dayOfWeek)));
    }

    public static Stream<Arguments> getDayArguments() {

        return Stream.of(
                Arguments.of("MONDAY", false),
                Arguments.of("TUESDAY", false),
                Arguments.of("WEDNESDAY", false),
                Arguments.of("THURSDAY", false),
                Arguments.of("FRIDAY", false),
                Arguments.of("SATURDAY", true),
                Arguments.of("SUNDAY", true)
        );
    }
}
