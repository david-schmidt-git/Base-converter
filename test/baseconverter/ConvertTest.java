package baseconverter;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author David
 */
public class ConvertTest {

    public ConvertTest() {
    }

    @BeforeAll
    public static void setUpClass() {
        System.out.println("Test");
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    void failingTest() {
        fail("test");
    }

    /**
     * Test of convertBetweenBases method, of class Convert.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testConvertBetweenBases() throws Exception {
        System.out.println("convertBetweenBases");
        String input = "12";
        int baseFrom = 10;
        int baseTo = 2;
        String expResult = "1100";
        String result = Convert.convertBetweenBases(input, baseFrom, baseTo);
        assertEquals(expResult, result);
    }

}
