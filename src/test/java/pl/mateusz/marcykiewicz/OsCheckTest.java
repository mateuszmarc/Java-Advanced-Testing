package pl.mateusz.marcykiewicz;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class OsCheckTest {

    @Test
    public void givenAssumingLinuxOS_whenOsIsLinux_thenShouldGetName() {
        Assumptions.assumeTrue(System.getProperty("os.name").contains("Linux"));
        assertTrue(System.getProperty("os.name").contains("Linux"));

    }

    @Test
    public void givenAssumingWindows_whenOsIsWindows_thenEqualsName() {
        Assumptions.assumeTrue(System.getProperty("os.name").contains("Windows"));
        assertTrue(System.getProperty("os.name").contains("Windows"));
    }

}
