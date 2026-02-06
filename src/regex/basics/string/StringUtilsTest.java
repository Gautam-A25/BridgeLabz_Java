package javacollectionstreams.regex.basics.string;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class StringUtilsTest {

    // Object of StringUtils class
    StringUtils utils = new StringUtils();

    // Test reverse method
    @Test
    void testReverse() {
        assertEquals("olleh", utils.reverse("hello"));
    }

    // Test palindrome check
    @Test
    void testPalindrome() {
        assertTrue(utils.isPalindrome("madam"));
    }

    // Test uppercase conversion
    @Test
    void testToUpperCase() {
        assertEquals("JAVA", utils.toUpperCase("java"));
    }
}

