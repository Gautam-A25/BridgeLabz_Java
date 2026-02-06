package javacollectionstreams.regex.basics.number;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NumberUtilsTest {

    // Creating object of NumberUtils
    NumberUtils utils = new NumberUtils();

    // Test for even numbers
    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6})
    void testEvenNumbers(int number) {
        assertTrue(utils.isEven(number));
    }

    // Test for odd numbers
    @ParameterizedTest
    @ValueSource(ints = {7, 9})
    void testOddNumbers(int number) {
        assertFalse(utils.isEven(number));
    }
}

