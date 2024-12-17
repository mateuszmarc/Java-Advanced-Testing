package pl.mateusz.marcykiewicz;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pl.mateusz.parametrizedtests.TextFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TextFormatterTest {


    @ParameterizedTest
    @CsvSource({

            "'    hello',          'hello'",

            "'hello    ',          'hello'",

            "'hello  world',       'hello world'",

            "'hello\tworld',      'hello world'",

            "'hello\t\tworld',   'hello world'",

            "'hello\nworld',      'hello world'",

            "'hello\n\nworld',   'hello world'"

    })
    void testFormat(String input, String expected) {

        assertEquals(expected, TextFormatter.format(input));

    }
}

